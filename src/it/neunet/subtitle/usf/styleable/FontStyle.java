package it.neunet.subtitle.usf.styleable;

import android.graphics.Color;

public class FontStyle {
	public static final String WEIGHT_NORMAL = "normal";
	public static final String WEIGHT_BOLD = "bold";
	public static final String WEIGHT_BOLDER = "bolder";
	public static final String WEIGHT_LIGHTER = "lighter";
	public static final String WEIGHT_100 = "100";
	public static final String WEIGHT_200 = "200";
	public static final String WEIGHT_300 = "300";
	public static final String WEIGHT_400 = "400";
	public static final String WEIGHT_500 = "500";
	public static final String WEIGHT_600 = "600";
	public static final String WEIGHT_700 = "700";
	public static final String WEIGHT_800 = "800";
	public static final String WEIGHT_900 = "900";

	public static final String WRAP_NO = "no";
	public static final String WRAP_AUTO = "auto";

	public static Integer SIZE_DEFAULT = 14;

	public static String FACE_DEFAULT = "Arial";
	public static String FAMILY_DEFAULT = "sans-serif";
	public static String WRAP_DEFAULT = WRAP_NO;
	public static String WEIGHT_DEFAULT = WEIGHT_NORMAL;

	public static Boolean ITALIC_DEFAULT = false;
	public static Boolean UNDERLINE_DEFAULT = false;

	public static Integer COLOR_DEFAULT = Color.WHITE;
	public static Integer BACKCOLOR_DEFAULT = Color.LTGRAY;
	public static Integer OUTLINE_COLOR_DEFAULT = Color.BLACK;
	public static Integer SHADOW_COLOR_DEFAULT = Color.TRANSPARENT;
	public static Integer ALPHA_DEFAULT = 0;
	public static Integer OUTLINE_LEVEL_DEFAULT = 1;
	public static Integer SHADOW_LEVEL_DEFAULT = 0;

	private String face;
	private String family;
	private Integer size;
	private Integer color;
	private String weight;
	private Boolean italic;
	private Boolean underline;
	private Integer alpha;
	private Integer backColor;
	private Integer outlineColor;
	private Integer outlineLevel;
	private Integer shadowColor;
	private Integer shadowLevel;
	private String wrap;

	/**
	 * 
	 */
	public FontStyle() {
		super();
		// this.face = FACE_DEFAULT;
		// this.family = FAMILY_DEFAULT;
		// this.size = SIZE_DEFAULT;
		// this.color = COLOR_DEFAULT;
		// this.weight = WEIGHT_NORMAL;
		// this.italic = ITALIC_DEFAULT;
		// this.underline = UNDERLINE_DEFAULT;
		// this.alpha = ALPHA_DEFAULT;
		// this.backColor = BACKCOLOR_DEFAULT;
		// this.outlineColor = OUTLINE_COLOR_DEFAULT;
		// this.outlineLevel = OUTLINE_LEVEL_DEFAULT;
		// this.shadowColor = SHADOW_COLOR_DEFAULT;
		// this.shadowLevel = SHADOW_LEVEL_DEFAULT;
		// this.wrap = WRAP_DEFAULT;
	}

	/**
	 * @param face
	 * @param family
	 * @param size
	 * @param relativeSize
	 * @param color
	 * @param weight
	 * @param italic
	 * @param underline
	 * @param alpha
	 * @param backColor
	 * @param outlineColor
	 * @param outlineLeve
	 * @param shadowColor
	 * @param shadowLevel
	 * @param wrap
	 */
	public FontStyle(String face, String family, Integer size, Integer color,
			String weight, Boolean italic, Boolean underline, Integer alpha,
			Integer backColor, Integer outlineColor, Integer outlineLeve,
			Integer shadowColor, Integer shadowLevel, String wrap) {
		super();
		this.face = face;
		this.family = family;
		this.size = size;
		this.color = color;
		this.weight = weight;
		this.italic = italic;
		this.underline = underline;
		this.alpha = alpha;
		this.backColor = backColor;
		this.outlineColor = outlineColor;
		this.outlineLevel = outlineLeve;
		this.shadowColor = shadowColor;
		this.shadowLevel = shadowLevel;
		this.wrap = wrap;
	}

	public FontStyle getFilledFontStyle() {
		FontStyle filledFontStyle = new FontStyle();

		filledFontStyle.face = (face != null) ? face : FACE_DEFAULT;
		filledFontStyle.family = (family != null) ? family : FAMILY_DEFAULT;
		filledFontStyle.size = (size != null) ? size : SIZE_DEFAULT;
		filledFontStyle.color = (color != null) ? color : COLOR_DEFAULT;
		filledFontStyle.weight = (weight != null) ? weight : WEIGHT_NORMAL;
		filledFontStyle.italic = (italic != null) ? italic : ITALIC_DEFAULT;
		filledFontStyle.underline = (underline != null) ? underline
				: UNDERLINE_DEFAULT;
		filledFontStyle.alpha = (alpha != null) ? alpha : ALPHA_DEFAULT;
		filledFontStyle.backColor = (backColor != null) ? backColor
				: BACKCOLOR_DEFAULT;
		filledFontStyle.outlineColor = (outlineColor != null) ? outlineColor
				: OUTLINE_COLOR_DEFAULT;
		filledFontStyle.outlineLevel = (outlineLevel != null) ? outlineLevel
				: OUTLINE_LEVEL_DEFAULT;
		filledFontStyle.shadowColor = (shadowColor != null) ? shadowColor
				: SHADOW_COLOR_DEFAULT;
		filledFontStyle.shadowLevel = (shadowLevel != null) ? shadowLevel
				: SHADOW_LEVEL_DEFAULT;
		filledFontStyle.wrap = (wrap != null) ? wrap : WRAP_DEFAULT;

		return filledFontStyle;
	}

	/**
	 * @return the face
	 */
	public String getFace() {
		return face;
	}

	/**
	 * @param face
	 *            the face to set
	 */
	public void setFace(String face) {
		if (face != null && !face.equals(""))
			this.face = face;
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family
	 *            the family to set
	 */
	public void setFamily(String family) {
		if (family != null && !family.equals(""))
			this.family = family;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		try {
			if (size != null && !size.equals("")) {
				// check if it is a relative size
				if (size.startsWith("+")) {
					this.size = SIZE_DEFAULT
							+ (int) (SIZE_DEFAULT * (Integer.parseInt(size
									.substring(1)) / 10.0));
				} else if (size.startsWith("-")) {
					this.size = SIZE_DEFAULT
							- (int) (SIZE_DEFAULT * (Integer.parseInt(size
									.substring(1)) / 10.0));
				} else {
					this.size = Integer.parseInt(size);
				}
			}
		} catch (Exception ex) {
			this.size = SIZE_DEFAULT;
		}
	}

	/**
	 * @return the color
	 */
	public Integer getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		if (color != null && !color.equals("")) {
			try {
				this.color = Color.parseColor(color);
			} catch (Exception ex) {
				this.color = COLOR_DEFAULT;
			}
		}
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Integer color) {
		this.color = color;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(String weight) {
		if (weight != null && !weight.equals(""))
			this.weight = weight;
	}

	/**
	 * @return the italic
	 */
	public Boolean isItalic() {
		return italic;
	}

	/**
	 * @param italic
	 *            the italic to set
	 */
	public void setItalic(Boolean italic) {
		this.italic = italic;
	}

	/**
	 * @param italic
	 *            the italic to set
	 */
	public void setItalic(String italic) {
		if (italic != null && !italic.equals(""))
			this.italic = italic.equals("yes");
	}

	/**
	 * @return the underline
	 */
	public Boolean isUnderline() {
		return underline;
	}

	/**
	 * @param underline
	 *            the underline to set
	 */
	public void setUnderline(Boolean underline) {
		this.underline = underline;
	}

	/**
	 * @param underline
	 *            the underline to set
	 */
	public void setUnderline(String underline) {
		if (underline != null && !underline.equals(""))
			this.underline = underline.equals("yes");
	}

	/**
	 * @return the alpha
	 */
	public Integer getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha
	 *            the alpha to set
	 */
	public void setAlpha(Integer alpha) {
		if (alpha != null)
			this.alpha = (alpha < 0) ? 0 : (alpha > 100 ? 100 : alpha);
	}

	/**
	 * @param alpha
	 *            the alpha to set
	 */
	public void setAlpha(String alpha) {
		if (alpha != null && !alpha.equals("")) {
			try {
				this.alpha = Integer.parseInt(alpha);
				this.alpha = (this.alpha < 0) ? 0 : (this.alpha > 100 ? 100
						: this.alpha);
			} catch (Exception ex) {
				this.alpha = ALPHA_DEFAULT;
			}
		}
	}

	/**
	 * @return the backColor
	 */
	public Integer getBackColor() {
		return backColor;
	}

	/**
	 * @param backColor
	 *            the backColor to set
	 */
	public void setBackColor(String backColor) {
		if (backColor != null && !backColor.equals(""))
			try {
				this.backColor = Color.parseColor(backColor);
			} catch (Exception ex) {
				this.backColor = BACKCOLOR_DEFAULT;
			}
	}

	/**
	 * @param backColor
	 *            the backColor to set
	 */
	public void setBackColor(Integer backColor) {
		this.backColor = backColor;
	}

	/**
	 * @return the outlineColor
	 */
	public Integer getOutlineColor() {
		return outlineColor;
	}

	/**
	 * @param outlineColor
	 *            the outlineColor to set
	 */
	public void setOutlineColor(String outlineColor) {
		if (outlineColor != null && !outlineColor.equals("")) {
			try {
				this.outlineColor = Color.parseColor(outlineColor);
			} catch (Exception ex) {
				this.outlineColor = OUTLINE_COLOR_DEFAULT;
			}
		}
	}

	/**
	 * @param outlineColor
	 *            the outlineColor to set
	 */
	public void setOutlineColor(Integer outlineColor) {
		this.outlineColor = outlineColor;
	}

	/**
	 * @return the outlineLeve
	 */
	public Integer getOutlineLevel() {
		return outlineLevel;
	}

	/**
	 * @param outlineLeve
	 *            the outlineLeve to set
	 */
	public void setOutlineLevel(Integer outlineLeve) {
		this.outlineLevel = outlineLeve;
	}

	/**
	 * @param outlineLeve
	 *            the outlineLevel to set
	 */
	public void setOutlineLevel(String outlineLevel) {
		if (outlineLevel != null && !outlineLevel.equals("")) {
			try {
				this.outlineLevel = Integer.parseInt(outlineLevel);
			} catch (Exception ex) {
				this.outlineLevel = OUTLINE_LEVEL_DEFAULT;
			}
		}
	}

	/**
	 * @return the shadowColor
	 */
	public Integer getShadowColor() {
		return shadowColor;
	}

	public String getShadowColorString() {
		return (shadowColor != null) ? shadowColor.toString() : null;
	}

	/**
	 * @param shadowColor
	 *            the shadowColor to set
	 */
	public void setShadowColor(String shadowColor) {
		if (shadowColor != null && !shadowColor.equals("")) {
			try {
				this.shadowColor = Color.parseColor(shadowColor);
			} catch (Exception ex) {
				this.shadowColor = SHADOW_COLOR_DEFAULT;
			}
		}
	}

	/**
	 * @param shadowColor
	 *            the shadowColor to set
	 */
	public void setShadowColor(Integer shadowColor) {
		this.shadowColor = shadowColor;
	}

	/**
	 * @return the shadowLevel
	 */
	public Integer getShadowLevel() {
		return shadowLevel;
	}

	/**
	 * @param shadowLevel
	 *            the shadowLevel to set
	 */
	public void setShadowLevel(Integer shadowLevel) {
		this.shadowLevel = shadowLevel;
	}

	/**
	 * @param shadowLevel
	 *            the shadowLevel to set
	 */
	public void setShadowLevel(String shadowLevel) {
		if (shadowLevel != null && !shadowLevel.equals("")) {
			try {
				this.shadowLevel = Integer.parseInt(shadowLevel);
			} catch (Exception ex) {
				this.shadowLevel = SHADOW_LEVEL_DEFAULT;
			}
		}
	}

	/**
	 * @return the wrap
	 */
	public String getWrap() {
		return wrap;
	}

	/**
	 * @param wrap
	 *            the wrap to set
	 */
	public void setWrap(String wrap) {
		if (wrap != null && !wrap.equals(""))
			this.wrap = wrap;
	}
	
	/**
	 * Override the default attributes, setting these new ones.
	 * @param style The new style to set as default
	 */
	public static void setDefault(FontStyle style){
		style = style.getFilledFontStyle();
		
		FontStyle.ALPHA_DEFAULT = style.alpha;
		FontStyle.BACKCOLOR_DEFAULT = style.backColor;
		FontStyle.COLOR_DEFAULT = style.color;
		FontStyle.FACE_DEFAULT = style.face;
		FontStyle.FAMILY_DEFAULT = style.family;
		FontStyle.ITALIC_DEFAULT = style.italic;
		FontStyle.OUTLINE_COLOR_DEFAULT = style.outlineColor;
		FontStyle.OUTLINE_LEVEL_DEFAULT = style.outlineLevel;
		FontStyle.SHADOW_COLOR_DEFAULT = style.shadowColor;
		FontStyle.SHADOW_LEVEL_DEFAULT = style.shadowLevel;
		FontStyle.SIZE_DEFAULT = style.size;
		FontStyle.UNDERLINE_DEFAULT = style.underline;
		FontStyle.WEIGHT_DEFAULT = style.weight;
		FontStyle.WRAP_DEFAULT = style.wrap;
	}

	public String toString() {
		return (face != null ? "\tFace: " + face + "\n" : "")
				+ (family != null ? "\tFamily: " + family + "\n" : "")
				+ (size != null ? "\tSize: " + size + "\n" : "")
				+ (color != null ? "\tColor: " + color + "\n" : "")
				+ (weight != null ? "\tWeight: " + weight + "\n" : "")
				+ (italic != null ? "\tItalic: " + italic + "\n" : "")
				+ (underline != null ? "\tUnderline: " + underline + "\n" : "")
				+ (alpha != null ? "\tAlpha: " + alpha + "\n" : "")
				+ (backColor != null ? "\tBackColor: " + backColor + "\n" : "")
				+ (outlineColor != null ? "\tOutlineColor: " + outlineColor
						+ "\n" : "")
				+ (outlineLevel != null ? "\tOutlineLevel: " + outlineLevel
						+ "\n" : "")
				+ (shadowColor != null ? "\tShadowColor: " + shadowColor + "\n"
						: "")
				+ (shadowLevel != null ? "\tShadowLevel: " + shadowLevel + "\n"
						: "") + (wrap != null ? "\tWrap: " + wrap + "\n" : "");

	}
}
