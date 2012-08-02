package it.neunet.subtitle.usf.styleable;

public class ImageElement extends StyleableElement {
	private String path;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public String toString() {
		return (path != null && !path.equals("")? "\tImage: " + path + "\n" : "") +
				(style != null ? "\tStyle: " + style + "\n" : "") +
				(effect != null ? "Effect: " + effect + "\n" : "");
	}
}
