package it.neunet.subtitle.usf;

import it.neunet.subtitle.usf.styleable.ImageElement;
import it.neunet.subtitle.usf.styleable.KaraokeElement;
import it.neunet.subtitle.usf.styleable.ShapeElement;
import it.neunet.subtitle.usf.styleable.TextElement;

import java.io.Serializable;
import java.util.ArrayList;

public class Subtitle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4780562802698354256L;
	public static final String TYPE_OPEN = "open";
	public static final String TYPE_CLOSED = "closed";
	public static final String TYPE_DEFAULT = TYPE_OPEN;
	private int startMillisecond;
	private int endMillisecond;
	private int duration;
	private String type;
	private ArrayList<TextElement> texts;
	private ArrayList<ImageElement> images;
	private ArrayList<KaraokeElement> karaokes;
	private ArrayList<ShapeElement> shapes;

	public Subtitle() {
		super();
		this.startMillisecond = -1;
		this.endMillisecond = -1;
		this.duration = -1;
		this.type = TYPE_DEFAULT;
		this.texts = new ArrayList<TextElement>();
		this.images = new ArrayList<ImageElement>();
		this.karaokes = new ArrayList<KaraokeElement>();
		this.shapes = new ArrayList<ShapeElement>();
	}
	
	private int parseTime(String time){
		// parse string to retrieve an int
		int hours, minutes, seconds, milliseconds;
		hours = minutes = seconds = milliseconds = 0;

		if(!time.equals("")){
			String[] items = time.split(":");
			if(items.length > 2){
				// full format
				hours = Integer.parseInt(items[0].trim());
				minutes = Integer.parseInt(items[1].trim());
				// split seconds from milliseconds
				String[] items2 = items[2].split("\\.|,");
				seconds = Integer.parseInt(items2[0].trim());
				milliseconds = Integer.parseInt(items2[1].trim());
			} else if(items.length == 1){
				// short format
				String[] items2 = items[0].split("\\.|,");
				if(items2.length == 2){
					seconds = Integer.parseInt(items[0].trim());
					milliseconds = Integer.parseInt(items[1].trim());
				} else {
					seconds = Integer.parseInt(items[0].trim());
				}
			}
		}
		return (hours * 3600 * 0000) + (minutes * 60 * 1000) + (seconds * 1000) + milliseconds;
	}

	/**
	 * @return the startMillisecond
	 */
	public int getStartMillisecond() {
		return startMillisecond;
	}

	/**
	 * @param startMillisecond
	 *            the startMillisecond to set
	 */
	public void setStartMillisecond(int startMillisecond) {
		this.startMillisecond = startMillisecond;
	}

	/**
	 * @param startMillisecond
	 *            the startMillisecond to set
	 */
	public void setStartMillisecond(String startMillisecond) {
		this.startMillisecond = parseTime(startMillisecond);
	}

	/**
	 * @return the endMillisecond
	 */
	public int getEndMillisecond() {
		return endMillisecond;
	}

	/**
	 * @param endMillisecond
	 *            the endMillisecond to set
	 */
	public void setEndMillisecond(int endMillisecond) {
		this.endMillisecond = endMillisecond;
	}

	/**
	 * @param endMillisecond
	 *            the endMillisecond to set
	 */
	public void setEndMillisecond(String endMillisecond) {
		this.endMillisecond = parseTime(endMillisecond);
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = parseTime(duration);
	}

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
	 * @return the texts
	 */
	public ArrayList<TextElement> getTexts() {
		return texts;
	}

	/**
	 * @param texts
	 *            the texts to set
	 */
	public void setTexts(ArrayList<TextElement> texts) {
		this.texts = texts;
	}

	/**
	 * @param text
	 *            the text to add
	 */
	public void addText(TextElement text) {
		if (this.texts == null)
			this.texts = new ArrayList<TextElement>();
		this.texts.add(text);
	}

	/**
	 * @return the images
	 */
	public ArrayList<ImageElement> getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(ArrayList<ImageElement> images) {
		this.images = images;
	}

	/**
	 * @param image
	 *            the image to add
	 */
	public void addImage(ImageElement image) {
		if (this.images == null)
			this.images = new ArrayList<ImageElement>();

		this.images.add(image);
	}

	/**
	 * @return the karaokes
	 */
	public ArrayList<KaraokeElement> getKaraokes() {
		return karaokes;
	}

	/**
	 * @param karaokes
	 *            the karaokes to set
	 */
	public void setKaraokes(ArrayList<KaraokeElement> karaokes) {
		this.karaokes = karaokes;
	}

	/**
	 * @param karaoke
	 *            the karaoke to add
	 */
	public void addKaraoke(KaraokeElement karaoke) {
		if (karaokes == null)
			karaokes = new ArrayList<KaraokeElement>();

		this.karaokes.add(karaoke);
	}

	/**
	 * @return the shapes
	 */
	public ArrayList<ShapeElement> getShapes() {
		return shapes;
	}

	/**
	 * @param shapes
	 *            the shapes to set
	 */
	public void setShapes(ArrayList<ShapeElement> shapes) {
		this.shapes = shapes;
	}

	/**
	 * @param shape
	 *            the shape to add
	 */
	public void addShape(ShapeElement shape) {
		if (shapes == null)
			shapes = new ArrayList<ShapeElement>();

		this.shapes.add(shape);
	}

	@Override
	public String toString() {
		return "\n--- Subtitle --- \n"
				+ "start: "
				+ startMillisecond
				+ "\n"
				+ "end: "
				+ endMillisecond
				+ "\n"
				+ "duration: "
				+ duration
				+ "\n"
				+ (type != null ? "type : " + type + "\n" : "")
				+ (texts.size() != 0 ? "--- texts --- \n" + texts + "\n" : "")
				+ (karaokes.size() != 0 ? "--- karaokes --- \n" + karaokes
						+ "\n" : "")
				+ (shapes.size() != 0 ? "--- shapes --- \n" + shapes + "\n"
						: "")
				+ (images.size() != 0 ? "--- images --- \n" + images + "\n"
						: "");
	}
}
