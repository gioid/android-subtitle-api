package it.neunet.subtitle.usf.styleable;

import android.view.Gravity;

public class Position {
	public static final String TOP_LEFT = "TopLeft";
	public static final String TOP_CENTER = "TopCenter";
	public static final String TOP_RIGHT = "TopRight";
	public static final String MIDDLE_LEFT = "MiddleLeft";
	public static final String MIDDLE_RIGHT = "MiddleRight";
	public static final String MIDDLE_CENTER = "MiddleCenter";
	public static final String BOTTOM_LEFT = "BottomLeft";
	public static final String BOTTOM_CENTER = "BottomCenter";
	public static final String BOTTOM_RIGHT = "BottomRight";
	public static final String RELATIVE_TO_WINDOW = "Window";
	public static final String RELATIVE_TO_SCREEN = "Screen";

	public static String ALIGNMENT_DEFAULT = TOP_CENTER;
	public static String HORIZONTAL_MARGIN_DEFAULT = "0";
	public static String VERTICAL_MARGIN_DEFAULT = "0";
	public static String RELATIVE_TO_DEFAULT = "0";
	public static Integer ROTATE_X_DEFAULT = 0;
	public static Integer ROTATE_Y_DEFAULT = 0;
	public static Integer ROTATE_Z_DEFAULT = 0;
	
	private String alignment;
	private String horizontalMargin;
	private String verticalMargin;
	private String relativeTo;
	private Integer rotateX;
	private Integer rotateY;
	private Integer rotateZ;

	/**
	 * 
	 */
	public Position() {
		super();
		alignment = horizontalMargin = verticalMargin = relativeTo = null;
		rotateX = rotateY = rotateZ = null;
	}

	/**
	 * @param alignment
	 * @param horizontalMargin
	 * @param relativeTo
	 * @param rotateX
	 * @param rotateY
	 * @param rotateZ
	 */
	public Position(String alignment, String horizontalMargin,
			String verticalMargin, String relativeTo, int rotateX, int rotateY,
			int rotateZ) {
		super();
		this.alignment = alignment;
		this.horizontalMargin = horizontalMargin;
		this.relativeTo = relativeTo;
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
	}
	
	public Position getFilledPosition(){
		Position p = new Position();
		
		p.alignment = (alignment != null)? alignment: ALIGNMENT_DEFAULT;
		p.horizontalMargin = (horizontalMargin != null)? horizontalMargin: HORIZONTAL_MARGIN_DEFAULT;
		p.verticalMargin = (verticalMargin != null)? verticalMargin: HORIZONTAL_MARGIN_DEFAULT;
		p.relativeTo = (relativeTo != null)? relativeTo: RELATIVE_TO_DEFAULT;
		p.rotateX = (rotateX != null)? rotateX: ROTATE_X_DEFAULT;
		p.rotateY = (rotateY != null)? rotateY: ROTATE_Y_DEFAULT;
		p.rotateZ = (rotateZ != null)? rotateZ: ROTATE_Z_DEFAULT;
		
		return p;
	}

	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return "".equals(alignment)? null: alignment;
	}

	/**
	 * @param alignment
	 *            the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	/**
	 * Convert the parsed alignment in Android sintax.
	 * 
	 * @return the alignment of this position, as a Gravity Constant
	 */
	public int getAndroidAlignment() {
		int flag = 0;

		if (alignment.equals(BOTTOM_CENTER))
			flag = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
		else if (alignment.equals(BOTTOM_LEFT))
			flag = Gravity.BOTTOM | Gravity.LEFT;
		else if (alignment.equals(BOTTOM_RIGHT))
			flag = Gravity.BOTTOM | Gravity.RIGHT;
		else if (alignment.equals(MIDDLE_LEFT))
			flag = Gravity.CENTER_VERTICAL | Gravity.LEFT;
		else if (alignment.equals(MIDDLE_CENTER))
			flag = Gravity.CENTER;
		else if (alignment.equals(MIDDLE_RIGHT))
			flag = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
		else if (alignment.equals(TOP_CENTER))
			flag = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
		else if (alignment.equals(TOP_LEFT))
			flag = Gravity.TOP | Gravity.LEFT;
		else if (alignment.equals(TOP_RIGHT))
			flag = Gravity.TOP | Gravity.RIGHT;

		return flag;
	}

	/**
	 * @return the horizontalMargin
	 */
	public String getHorizontalMargin() {
		return "".equals(horizontalMargin)? null: horizontalMargin;
	}

	/**
	 * @param horizontalMargin
	 *            the horizontalMargin to set
	 */
	public void setHorizontalMargin(String horizontalMargin) {
		this.horizontalMargin = horizontalMargin;
	}

	/**
	 * Convert the parsed margin in Android margin
	 * @return the pixel of margin for Android devices
	 */
	public int getAndroidHorizontalMargin() {
		int margin;
		try {
			margin = Integer.parseInt(this.horizontalMargin);
		} catch (Exception ex) {
			margin = 0;
		}

		return margin;
	}

	/**
	 * @return the verticalMargin
	 */
	public String getVerticalMargin() {
		return "".equals(verticalMargin)? null: verticalMargin;
	}

	/**
	 * @param verticalMargin
	 *            the verticalMargin to set
	 */
	public void setVerticalMargin(String verticalMargin) {
		this.verticalMargin = verticalMargin;
	}

	/**
	 * Convert the parsed margin in Android margin
	 * @return the pixel of margin for Android devices
	 */
	public int getAndroidVerticalMargin() {
		int margin;
		try {
			margin = Integer.parseInt(this.verticalMargin);
		} catch (Exception ex) {
			margin = 0;
		}

		return margin;
	}

	/**
	 * @return the relativeTo
	 */
	public String getRelativeTo() {
		return "".equals(relativeTo)? null: relativeTo;
	}

	/**
	 * @param relativeTo
	 *            the relativeTo to set
	 */
	public void setRelativeTo(String relativeTo) {
		this.relativeTo = relativeTo;
	}

	/**
	 * @return the rotateX
	 */
	public Integer getRotateX() {
		return "".equals(rotateX)? null: rotateX;
	}

	/**
	 * @param rotateX
	 *            the rotateX to set
	 */
	public void setRotateX(Integer rotateX) {
		this.rotateX = rotateX;
	}

	/**
	 * @param rotateX
	 *            the rotateX to set
	 */
	public void setRotateX(String rotateX) {
		try {
			this.rotateX = Integer.parseInt(rotateX);
			this.rotateX = (this.rotateX < 0) ? 0 : (this.rotateX > 359 ? 359
					: this.rotateX);
		} catch (Exception ex) {
			this.rotateX = 0;
		}
	}

	/**
	 * @return the rotateY
	 */
	public Integer getRotateY() {
		return "".equals(rotateY)? null: rotateY;
	}

	/**
	 * @param rotateY
	 *            the rotateY to set
	 */
	public void setRotateY(Integer rotateY) {
		this.rotateY = rotateY;
	}

	/**
	 * @param rotateY
	 *            the rotateY to set
	 */
	public void setRotateY(String rotateY) {
		try {
			this.rotateY = Integer.parseInt(rotateY);
			this.rotateY = (this.rotateY < 0) ? 0 : (this.rotateY > 359 ? 359
					: this.rotateY);
		} catch (Exception ex) {
			this.rotateY = 0;
		}
	}

	/**
	 * @return the rotateZ
	 */
	public Integer getRotateZ() {
		return "".equals(rotateZ)? null: rotateZ;
	}

	/**
	 * @param rotateZ
	 *            the rotateZ to set
	 */
	public void setRotateZ(Integer rotateZ) {
		this.rotateZ = rotateZ;
	}

	/**
	 * @param rotateZ
	 *            the rotateZ to set
	 */
	public void setRotateZ(String rotateZ) {
		try {
			this.rotateZ = Integer.parseInt(rotateZ);
			this.rotateZ = (this.rotateZ < 0) ? 0 : (this.rotateZ > 359 ? 359
					: this.rotateZ);
		} catch (Exception ex) {
			this.rotateZ = 0;
		}
	}
	
	/**
	 * Override the default attributes, setting these new ones.
	 * @param style The new style to set as default
	 */
	public static void setDefault(Position position){
		position = position.getFilledPosition();
		
		Position.ALIGNMENT_DEFAULT = position.alignment;
		Position.RELATIVE_TO_DEFAULT = position.relativeTo;
		Position.ROTATE_X_DEFAULT = position.rotateX;
		Position.ROTATE_Y_DEFAULT = position.rotateY;
		Position.ROTATE_Z_DEFAULT = position.rotateZ;
		Position.VERTICAL_MARGIN_DEFAULT = position.verticalMargin;
		Position.HORIZONTAL_MARGIN_DEFAULT = position.horizontalMargin;
	}

	@Override
	public String toString() {
		return (alignment != null ? "\tAlignment : " + alignment + "\n" : "")
				+ (horizontalMargin != null ? "\tHorizontalMargin: "
						+ horizontalMargin + "\n" : "")
				+ (verticalMargin != null ? "\tVerticalMargin : "
						+ verticalMargin + "\n" : "")
				+ (relativeTo != null ? "\tRelativeTo: " + relativeTo + "\n"
						: "")
				+ (rotateX != null ? "\tRotateX: " + rotateX + "\n" : "")
				+ (rotateY != null ? "\tRotateY: " + rotateY + "\n" : "")
				+ (rotateZ != null ? "\tRotateZ: " + rotateZ + "\n" : "");
	}
}
