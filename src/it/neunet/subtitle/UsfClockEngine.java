package it.neunet.subtitle;

import it.neunet.subtitle.usf.Subtitle;
import it.neunet.subtitle.usf.Subtitles;
import it.neunet.subtitle.usf.Usf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import android.media.MediaPlayer;

public class UsfClockEngine extends Thread {

	private Usf usf;
	private Subtitles subtitles;
	private UsfListener usfListener;
	private MediaPlayer player;
	private Lock playerLock;
	private int lastTime;

	public UsfClockEngine(Usf usf, MediaPlayer player, UsfListener listener) {
		this.lastTime = -1;
		this.setSubtitle(usf);
		this.player = player;
		this.usfListener = listener;
		this.playerLock = new ReentrantLock();
	}

	public void setSubtitle(Usf subtitle){
		this.usf = subtitle;
		if (this.usf != null) {
			// get the first subtitles available
			if (usf.getSubtitles().size() > 0)
				this.subtitles = usf.getSubtitles().get(0);
		}	
	}
	
	public Usf getSubtitle(){
		return this.usf;
	}
	
	public void setLanguageCode(String languageCode) {
		if (languageCode != null) {
			for (Subtitles s : usf.getSubtitles()) {
				if (languageCode.equals(s.getLanguageCode()))
					this.subtitles = s;
			}
		}

		if (this.subtitles == null) {
			// get the first subtitles available
			if (usf.getSubtitles().size() > 0)
				this.subtitles = usf.getSubtitles().get(0);
		}
	}

	@Override
	public void run() {
		boolean go = false;
		
		do {
			// acquire the use of the player
			playerLock.lock();
			go = player != null;

			try {
				if (go && player.isPlaying()) {
					// search for a subtitle starting at the player position
					int time = player.getCurrentPosition();
					if (time != lastTime) {
						for (Subtitle s : subtitles.getSubtitles()) {
							if (s.getStartMillisecond() > lastTime && s.getStartMillisecond() <= time)
								this.usfListener.onSubtitleStart(s);
							else if (s.getEndMillisecond() > lastTime && s.getEndMillisecond() <= time)
								this.usfListener.onSubtitleEnd(s);
//							else if (s.getStartMillisecond() < time
//									&& s.getEndMillisecond() > time)
//								this.usfListener.onSubtitleContinue(s);
						}
						lastTime = time;
					}
					// take the cpu breath for a little bit time, in order to
					// poll
					// with a 1 millisecond resolution
					Thread.sleep(1);
				}
			} catch (Exception ex) {
				go = false;
			} finally {
				playerLock.unlock();
			}
		} while (go);
	}

	public void detach() {
		playerLock.lock();
		player = null;
		playerLock.unlock();
	}

	interface UsfListener {
		public void onSubtitleStart(Subtitle subtitle);

		public void onSubtitleContinue(Subtitle subtitle);

		public void onSubtitleEnd(Subtitle subtitle);
	}
}
