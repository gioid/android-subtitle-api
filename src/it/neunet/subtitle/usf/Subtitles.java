package it.neunet.subtitle.usf;

import java.util.ArrayList;

public class Subtitles {
	private Usf owner;
	private String languageCode;
	private String language;
	private String languageextCode;
	private String languageext;
	private ArrayList<Subtitle> subtitles;
	
	/**
	 * 
	 */
	public Subtitles() {
		super();
		subtitles = new ArrayList<Subtitle>();
	}

	/**
	 * @param owner
	 * @param languageCode
	 * @param language
	 * @param languageextCode
	 * @param languageext
	 * @param subtitles
	 */
	public Subtitles(Usf owner, String languageCode, String language,
			String languageextCode, String languageext,
			ArrayList<Subtitle> subtitles) {
		super();
		this.owner = owner;
		this.languageCode = languageCode;
		this.language = language;
		this.languageextCode = languageextCode;
		this.languageext = languageext;
		this.subtitles = subtitles;
	}

	/**
	 * @return the owner
	 */
	public Usf getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Usf owner) {
		this.owner = owner;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the languageextCode
	 */
	public String getLanguageextCode() {
		return languageextCode;
	}

	/**
	 * @param languageextCode the languageextCode to set
	 */
	public void setLanguageextCode(String languageextCode) {
		this.languageextCode = languageextCode;
	}

	/**
	 * @return the languageext
	 */
	public String getLanguageext() {
		return languageext;
	}

	/**
	 * @param languageext the languageext to set
	 */
	public void setLanguageext(String languageext) {
		this.languageext = languageext;
	}

	/**
	 * @return the subtitles
	 */
	public ArrayList<Subtitle> getSubtitles() {
		return subtitles;
	}

	/**
	 * @param subtitles the subtitles to set
	 */
	public void setSubtitles(ArrayList<Subtitle> subtitles) {
		this.subtitles = subtitles;
	}
	/**
	 * 
	 * @param subtitle the subtitle to add
	 */
	public void addSubtitle(Subtitle subtitle){
		if(subtitles != null)
			subtitles.add(subtitle);
	}
	@Override
	public String toString(){
		String base = "--- SUBTITLE TRACK ---\n"+
			(languageCode != null ? "\tLanguage:[ " + languageCode + " ] " + language + "\n": "") +
			(languageextCode != null?"\tLanguageext: [ " + languageextCode + " ] " + languageext + "\n": "");
		
		String composed = "";
		
		for(Subtitle s: subtitles){
			composed += s.toString();
		}
		
		return base + composed + "\n---END SUBTITLE TRACK ---";
				
	}
	
}
