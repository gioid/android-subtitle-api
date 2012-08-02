package it.neunet.subtitle.usf;

import it.neunet.subtitle.usf.styleable.Style;

import java.util.ArrayList;
import java.util.HashMap;

public class Usf {
	private Metadata metadata;
	private HashMap<String, Style> styles;
	private HashMap<String, Effect> effects;
	private ArrayList<Subtitles> subtitles;

	/**
	 * 
	 */
	public Usf() {
		super();
		styles = new HashMap<String, Style>();
		effects = new HashMap<String, Effect>();
		subtitles = new ArrayList<Subtitles>();
	}

	/**
	 * @param metadata
	 * @param styles
	 * @param effects
	 * @param subtitles
	 */
	public Usf(Metadata metadata, HashMap<String, Style> styles,
			HashMap<String, Effect> effects, ArrayList<Subtitles> subtitles) {
		super();
		this.metadata = metadata;
		this.styles = styles;
		this.effects = effects;
		this.subtitles = subtitles;

		if (styles == null)
			styles = new HashMap<String, Style>();

		if (effects == null)
			effects = new HashMap<String, Effect>();

		if (subtitles == null)
			subtitles = new ArrayList<Subtitles>();
	}

	/**
	 * @return the metadata
	 */
	public Metadata getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata
	 *            the metadata to set
	 */
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the styles
	 */
	public HashMap<String, Style> getStyles() {
		return styles;
	}

	/**
	 * @param styles
	 *            the styles to set
	 */
	public void setStyles(HashMap<String, Style> styles) {
		this.styles = styles;
	}

	/**
	 * Add the style at the document, replacing any existing style with the same
	 * name.
	 * 
	 * @param style
	 *            The style to add.
	 */
	public void addStyle(Style style) {
		if (style != null)
			styles.put(style.getName(), style);
	}

	/**
	 * Retrieve the style with the specified name, if exists.
	 * 
	 * @param name
	 *            The name of the style
	 * @return The style with the specified name if exists, null otherwise
	 */
	public Style getStyleByName(String name) {
		return (styles != null) ? styles.get(name) : null;
	}

	/**
	 * @return the effects
	 */
	public HashMap<String, Effect> getEffects() {
		return effects;
	}

	/**
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects(HashMap<String, Effect> effects) {
		this.effects = effects;
	}

	/**
	 * Add the effect at the document, replacing any existing effect with the
	 * same name.
	 * 
	 * @param effect
	 *            The effect to add.
	 */
	public void addEffect(Effect effect) {
		if (effect != null)
			effects.put(effect.getName(), effect);
	}

	/**
	 * Retrieve the effect with the specified name, if exists.
	 * 
	 * @param name
	 *            The name of the effect.
	 * @return The effect with the specified name if exists, null otherwise.
	 */
	public Effect getEffectByName(String name) {
		return (effects != null) ? effects.get(name) : null;
	}

	/**
	 * @return the subtitles
	 */
	public ArrayList<Subtitles> getSubtitles() {
		return subtitles;
	}

	/**
	 * @param subtitles
	 *            the subtitles to set
	 */
	public void setSubtitles(ArrayList<Subtitles> subtitles) {
		this.subtitles = subtitles;
	}

	/**
	 * Add the subtitle at the document.
	 * 
	 * @param subtitle
	 *            The subtitle to add at the document.
	 */
	public void addSubtitle(Subtitles subtitle) {
		if (subtitles != null)
			subtitles.add(subtitle);
	}
}
