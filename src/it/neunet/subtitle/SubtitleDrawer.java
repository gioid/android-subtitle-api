package it.neunet.subtitle;

import it.neunet.subtitle.usf.Subtitle;
import it.neunet.subtitle.usf.Usf;
import it.neunet.subtitle.usf.styleable.ImageElement;
import it.neunet.subtitle.usf.styleable.Style;
import it.neunet.subtitle.usf.styleable.TextElement;

import java.util.Hashtable;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class SubtitleDrawer implements UsfClockEngine.UsfListener {
	private UsfClockEngine clockEngine;
	private FrameLayout gui;
	private Hashtable<TextElement, TextView> subTable;
	private Hashtable<ImageElement, ImageView> imageTable;
	
	/**
	 * @param clockEngine
	 * @param gui
	 */
	public SubtitleDrawer(MediaPlayer player, Usf usf, FrameLayout gui){
		super();
		this.subTable = new Hashtable<TextElement, TextView>();
		this.imageTable = new Hashtable<ImageElement, ImageView>();
		this.clockEngine = new UsfClockEngine(usf, player, this);
		this.gui = gui;
	}

	/**
	 * @return the clockEngine
	 */
	public UsfClockEngine getClockEngine() {
		return clockEngine;
	}

	/**
	 * @param clockEngine the clockEngine to set
	 */
	public void setClockEngine(UsfClockEngine clockEngine) {
		this.clockEngine = clockEngine;
	}

	/**
	 * @return the gui
	 */
	public FrameLayout getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(FrameLayout gui) {
		this.gui = gui;
	}
	
	public void setSubtitle(Usf subtitle){
		// set this new subtitle to the engine
		this.clockEngine.setSubtitle(subtitle);
		// and clean all previous subtitles rendered
		this.gui.removeAllViews();
		this.subTable.clear();
		this.imageTable.clear();
	}
	
	public Usf getSubtitle(){
		return clockEngine.getSubtitle();
	}
	
	public void start(){
		clockEngine.start();
	}
	
	private void addTextElement(TextElement te){
		String xhtmlText = te.getXhtmlText();
		TextView tv = new TextView(gui.getContext());
		Style elementStyle = te.getStyle().getFilledStyle();
		tv.setTypeface(Typeface.create(elementStyle.getFontStyle().getFamily(), 0));
		tv.setTextSize(elementStyle.getFontStyle().getSize());
		tv.setTextColor(elementStyle.getFontStyle().getColor());
		if(elementStyle.getFontStyle().isItalic())
			xhtmlText = "<i>" + xhtmlText + "</i>";
		if(elementStyle.getFontStyle().isUnderline())
			xhtmlText = "<u>" + xhtmlText + "</u>";
		tv.setText(Html.fromHtml(xhtmlText));
		tv.setBackgroundColor(elementStyle.getFontStyle().getBackColor());
		tv.setShadowLayer(elementStyle.getFontStyle().getShadowLevel(), 0, 0, elementStyle.getFontStyle().getShadowColor());
		FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
		parms.gravity = elementStyle.getPosition().getAndroidAlignment();
		parms.setMargins(elementStyle.getPosition().getAndroidHorizontalMargin(), 
				elementStyle.getPosition().getAndroidVerticalMargin(), 
				elementStyle.getPosition().getAndroidHorizontalMargin(), 
				elementStyle.getPosition().getAndroidVerticalMargin());
		gui.addView(tv, parms);
		this.subTable.put(te, tv);
	}
	
	private void removeTextElement(TextElement te){
		gui.removeView(this.subTable.remove(te));
	}
	
	private void addImageElement(ImageElement ie){
		Style elementStyle = ie.getStyle().getFilledStyle();
		ImageView iv = new ImageView(gui.getContext());
		iv.setImageResource(R.drawable.icon);
		FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
		parms.gravity = elementStyle.getPosition().getAndroidAlignment();
		parms.setMargins(elementStyle.getPosition().getAndroidHorizontalMargin(), 
				elementStyle.getPosition().getAndroidVerticalMargin(), 
				elementStyle.getPosition().getAndroidHorizontalMargin(), 
				elementStyle.getPosition().getAndroidVerticalMargin());
		gui.addView(iv, parms);
		imageTable.put(ie, iv);
	}
	
	private void removeImageElement(ImageElement ie){
		gui.removeView(imageTable.remove(ie));
	}
	
	private Handler onSubtitleStartHandler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	    	Subtitle sub = (Subtitle) msg.getData().getSerializable("subtitle");
	    	// parse the subtitle and create view to handle its contents
	    	for(TextElement te: sub.getTexts()){
	    		addTextElement(te);
	    	}
	    	for(ImageElement ie: sub.getImages()){
	    		addImageElement(ie);
	    	}
	    }
	};
	
	private Handler onSubtitleEndHandler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	    	Subtitle sub = (Subtitle) msg.getData().getSerializable("subtitle");
	    	// parse the subtitle and destroy view to remove its contents
	    	for(TextElement te: sub.getTexts())
	    		removeTextElement(te);
	    	for(ImageElement ie: sub.getImages()){
	    		removeImageElement(ie);
	    	}
	    }
	};

	@Override
	public void onSubtitleStart(Subtitle subtitle) {
		Message msg = onSubtitleStartHandler.obtainMessage();
		Bundle b = new Bundle();
		b.putSerializable("subtitle", subtitle);
		msg.setData(b);
		onSubtitleStartHandler.sendMessage(msg);	
	}

	@Override
	public void onSubtitleContinue(Subtitle subtitle) {	
	}

	@Override
	public void onSubtitleEnd(Subtitle subtitle) {
		Message msg = onSubtitleEndHandler.obtainMessage();
		Bundle b = new Bundle();
		b.putSerializable("subtitle", subtitle);
		msg.setData(b);
		onSubtitleEndHandler.sendMessage(msg);
	}
}
