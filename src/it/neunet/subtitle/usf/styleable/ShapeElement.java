package it.neunet.subtitle.usf.styleable;

public class ShapeElement extends StyleableElement {
	protected String type;
	protected Integer width;
	protected Integer height;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(String width) {
		if (width != null && !width.equals("")) {
			try {
				this.width = Integer.parseInt(width);
			} catch (Exception ex) {
				this.width = null;
			}
		}
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		if (height != null && !height.equals("")) {
			try {
				this.height = Integer.parseInt(height);
			} catch (Exception ex) {
				this.height = null;
			}
		}
	}

	public String toString() {
		return (type != null && !type.equals("") ? "\tType: " + type + "\n"
				: "")
				+ (width != null ? "\tWidth: " + width + "\n" : "")
				+ (height != null ? "\tHeight: " + height + "\n" : "");
	}
}
