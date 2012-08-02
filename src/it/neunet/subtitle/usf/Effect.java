package it.neunet.subtitle.usf;

import java.util.ArrayList;

public class Effect {
	private String name;
	private ArrayList<KeyFrame> keyFrames;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the keyFrames
	 */
	public ArrayList<KeyFrame> getKeyFrames() {
		return keyFrames;
	}
	/**
	 * @param keyFrames the keyFrames to set
	 */
	public void setKeyFrames(ArrayList<KeyFrame> keyFrames) {
		this.keyFrames = keyFrames;
	}
}
