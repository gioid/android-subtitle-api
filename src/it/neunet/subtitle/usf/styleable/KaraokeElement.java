package it.neunet.subtitle.usf.styleable;

public class KaraokeElement extends StyleableElement {

	@Override
	public String toString() {
		return (style != null? "\tStyle: " + style + "\n" : "")
				+ (effect != null ? "Effect: " + effect + "\n" : "");
	}
}
