package it.neunet.subtitle.usf.styleable;

public class TextElement extends StyleableElement {
	private String speaker;
	private String xhtmlText;

	public TextElement(){
		super();
		this.style = new Style();
	}
	
	public TextElement(String xhtmlText){
		this();
		this.xhtmlText = xhtmlText;
	}
	
	/**
	 * @return the speaker
	 */
	public String getSpeaker() {
		return speaker;
	}

	/**
	 * @param speaker
	 *            the speaker to set
	 */
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	/**
	 * @return the xhtmlText
	 */
	public String getXhtmlText() {
		return xhtmlText;
	}

	/**
	 * @param xhtmlText
	 *            the xhtmlText to set
	 */
	public void setXhtmlText(String xhtmlText) {
		this.xhtmlText = xhtmlText;
	}

	@Override
	public String toString() {
		return (speaker != null && !speaker.equals("")? "Speaker: " + speaker + "\n": "") + 
				(xhtmlText != null && !xhtmlText.equals("")? "Text: " + xhtmlText + "\n": "") +
				(style != null? "Style: " + style + "\n" : "") + 
				(effect != null? "Effect: " + effect + "\n": "");
	}
}
