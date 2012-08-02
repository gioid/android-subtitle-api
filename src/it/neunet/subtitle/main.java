package it.neunet.subtitle;

import it.neunet.subtitle.usf.Usf;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class main extends Activity implements SurfaceHolder.Callback,
		MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
	public static final int STATE_NOT_PREPARED = -1;
	public static final int STATE_STOP = 0;
	public static final int STATE_PAUSE = 1;
	public static final int STATE_PLAY = 2;

	private MediaPlayer player;
	private SurfaceView surfaceView;
	private SurfaceHolder surfaceHolder;
	private int state;
	private Usf usf;
	private Usf srt;
	private SubtitleDrawer subDrawer;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param surfaceView
	 * @param surfaceHolder
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// parse the string
		Document doc;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(getResources().openRawResource(R.raw.example));
			usf = new UsfParser(doc).parseDoc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			srt = new SrtParser(getResources().openRawResource(R.raw.srt))
					.parseDoc();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		surfaceView = (SurfaceView) findViewById(R.id.surface);
		surfaceView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// switch between pause/play
				if (state != STATE_PLAY)
					play();
				else
					pause();
			}
		});

		surfaceHolder = surfaceView.getHolder();
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		surfaceHolder.addCallback(this);

		player = new MediaPlayer();
		subDrawer = new SubtitleDrawer(player, usf,
				(FrameLayout) findViewById(R.id.subtitle_space));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);

		return true;
	}

	public boolean onMenuOpened(int featureId, Menu menu) {
		if (menu != null) {
			MenuItem usfItem = menu.findItem(R.id.usf);
			MenuItem srtItem = menu.findItem(R.id.srt);

			srtItem.setEnabled(this.subDrawer.getSubtitle() != this.srt);
			usfItem.setEnabled(this.subDrawer.getSubtitle() == this.srt);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);

		if (item.getItemId() == R.id.srt) {
			this.subDrawer.setSubtitle(srt);
		} else {
			this.subDrawer.setSubtitle(usf);
		}

		return true;
	}

	private void play() {
		if (state == STATE_NOT_PREPARED) {
			// preparing player
			try {
				player.setDataSource("/mnt/sdcard/video1.mp4");
				player.prepareAsync();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// start player
			player.start();
			// update state
			state = STATE_PLAY;
		}
	}

	private void stop() {
		if (state != STATE_NOT_PREPARED) {
			player.stop();
		}
		// update state
		state = STATE_STOP;
	}

	private void pause() {
		if (state == STATE_PLAY) {
			player.pause();
		}
		state = STATE_PAUSE;
		// show pause icon
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		player.release();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		state = STATE_NOT_PREPARED;
		player.setScreenOnWhilePlaying(true);
		player.setOnPreparedListener(this);
		player.setOnErrorListener(this);
		player.setDisplay(surfaceHolder);

		play();
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// start the stream playback
		state = STATE_PLAY;
		subDrawer.start();
		play();
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		Toast.makeText(this, "Error " + what + ": " + extra, Toast.LENGTH_SHORT).show();
		return true;
	}
}