package it.neunet.subtitle.usf.styleable;

public class Style {
	private String name;
	private FontStyle fontStyle;
	private Position position;
	private Style filledStyle;
	
	/**
	 * 
	 */
	public Style() {
		super();
		fontStyle = new FontStyle();
		position = new Position();
	}

	/**
	 * @param name
	 * @param fontStyle
	 * @param position
	 */
	public Style(String name, FontStyle fontStyle, Position position) {
		super();
		this.name = name;
		this.fontStyle = fontStyle;
		this.position = position;
	}

	/**
	 * Apply the given style to this. the attribute of the given style will
	 * overwrite the existing ones: all the attribute not redefined in the given
	 * style will be kept.
	 * 
	 * @param style The style to apply at this style.
	 */
	public void applyStyle(Style style) {
		if (this.fontStyle == null)
			this.fontStyle = new FontStyle();
		if (this.position == null)
			this.position = new Position();

		FontStyle fontStyle = (style != null) ? style.getFontStyle() : null;
		if (fontStyle != null) {
			this.name = style.name != null ? style.name: this.name;
			this.fontStyle.setFace(fontStyle.getFace() != null ? fontStyle
					.getFace() : this.fontStyle.getFace());
			this.fontStyle.setFamily(fontStyle.getFamily() != null ? fontStyle
					.getFamily() : this.fontStyle.getFamily());
			this.fontStyle.setSize(fontStyle.getSize() != null ? fontStyle
					.getSize() : this.fontStyle.getSize());
			this.fontStyle.setColor(fontStyle.getColor() != null ? fontStyle
					.getColor() : this.fontStyle.getColor());
			this.fontStyle.setWeight(fontStyle.getWeight() != null ? fontStyle
					.getWeight() : this.fontStyle.getWeight());
			this.fontStyle.setItalic(fontStyle.isItalic() != null ? fontStyle
					.isItalic() : this.fontStyle.isItalic());
			this.fontStyle
					.setUnderline(fontStyle.isUnderline() != null ? fontStyle
							.isUnderline() : this.fontStyle.isUnderline());
			this.fontStyle.setAlpha(fontStyle.getAlpha() != null ? fontStyle
					.getAlpha() : this.fontStyle.getAlpha());
			this.fontStyle
					.setBackColor(fontStyle.getBackColor() != null ? fontStyle
							.getBackColor() : this.fontStyle.getBackColor());
			this.fontStyle
					.setOutlineColor(fontStyle.getOutlineColor() != null ? fontStyle
							.getOutlineColor() : this.fontStyle
							.getOutlineColor());
			this.fontStyle
					.setOutlineLevel(fontStyle.getOutlineLevel() != null ? fontStyle
							.getOutlineLevel() : this.fontStyle
							.getOutlineLevel());
			this.fontStyle
					.setShadowColor(fontStyle.getShadowColor() != null ? fontStyle
							.getShadowColor() : this.fontStyle.getShadowColor());
			this.fontStyle
					.setShadowLevel(fontStyle.getShadowLevel() != null ? fontStyle
							.getShadowLevel() : this.fontStyle.getShadowLevel());
			this.fontStyle.setWrap(fontStyle.getWrap() != null ? fontStyle
					.getWrap() : this.fontStyle.getWrap());
		}

		Position position = (style != null) ? style.getPosition() : null;
		if (position != null) {
			this.position
					.setAlignment(position.getAlignment() != null ? position
							.getAlignment() : this.position.getAlignment());
			this.position
					.setHorizontalMargin(position.getHorizontalMargin() != null ? position
							.getHorizontalMargin() : this.position
							.getHorizontalMargin());
			this.position
					.setVerticalMargin(position.getVerticalMargin() != null ? position
							.getVerticalMargin() : this.position
							.getVerticalMargin());
			this.position
					.setRelativeTo(position.getRelativeTo() != null ? position
							.getRelativeTo() : this.position.getRelativeTo());
			this.position.setRotateX(position.getRotateX() != null ? position
					.getRotateX() : this.position.getRotateX());
			this.position.setRotateY(position.getRotateY() != null ? position
					.getRotateY() : this.position.getRotateY());
			this.position.setRotateZ(position.getRotateZ() != null ? position
					.getRotateZ() : this.position.getRotateZ());
		}

	}
	
	public Style getFilledStyle(){
		if(filledStyle == null){
			filledStyle = new Style();			
			filledStyle.setFontStyle(fontStyle.getFilledFontStyle());
			filledStyle.setPosition(position.getFilledPosition());
		}
		return filledStyle;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fontStyle
	 */
	public FontStyle getFontStyle() {
		return fontStyle;
	}

	/**
	 * @param fontStyle
	 *            the fontStyle to set
	 */
	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Override the default attributes, setting these new ones.
	 * @param style The new style to set as default
	 */
	public static void setDefault(Style style){
		FontStyle.setDefault(style.getFontStyle());
		Position.setDefault(style.getPosition());
	}
	
	@Override
	public String toString() {
		return "--- STYLE ---\n\tName: " + name + "\n\tFontStyle:\n"
				+ fontStyle + "\n" + "\tPosition:\n" + position
				+ "\n--- END STYLE ---";
	}
}
