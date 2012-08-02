package it.neunet.subtitle.usf;

public class Metadata {
	private String title;
	private Author author;
	private String languageCode;
	private String language;
	private String date;
	private String comment;
	private String languageext;
	private String languageextCode;
	
	/**
	 * 
	 */
	public Metadata() {
		super();
	}
	/**
	 * @param title
	 * @param author
	 * @param languageCode
	 * @param language
	 * @param date
	 * @param comment
	 * @param languageext
	 * @param languageextCode
	 */
	public Metadata(String title, Author author, String languageCode,
			String language, String date, String comment, String languageext,
			String languageextCode) {
		super();
		this.title = title;
		this.author = author;
		this.languageCode = languageCode;
		this.language = language;
		this.date = date;
		this.comment = comment;
		this.languageext = languageext;
		this.languageextCode = languageextCode;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	
	@Override
	public String toString(){
		return "Title: " + title + "\n" +
			   "Author: " + author + "\n" +
			   "Language: [ " + languageCode + " ] " + language + "\n" +
			   "Date: " + date + "\n" +
			   "Comment: " + comment + "\n" +
			   "LanguageExt: [ " + languageextCode + " ] " + languageext + "\n"; 
	}
}
