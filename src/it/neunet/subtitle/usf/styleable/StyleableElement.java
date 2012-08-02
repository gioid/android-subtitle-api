package it.neunet.subtitle.usf.styleable;

import it.neunet.subtitle.usf.Effect;

public abstract class StyleableElement {
	// style
	protected Style style;
	// effect
	protected Effect effect;

	public void applyStyle(Style style) {
		if(this.style == null)
			this.style = new Style();
		
		this.style.applyStyle(style);
	}
	/**
	 * Return the style
	 * @return the style
	 */
	public Style getStyle(){
		return this.style;
	}
	
	/**
	 * @return the effect
	 */
	public Effect getEffect() {
		return effect;
	}

	/**
	 * @param effect the effect to set
	 */
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
}
