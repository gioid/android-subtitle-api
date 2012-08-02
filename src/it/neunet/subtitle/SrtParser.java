package it.neunet.subtitle;

import it.neunet.subtitle.usf.Subtitle;
import it.neunet.subtitle.usf.Subtitles;
import it.neunet.subtitle.usf.Usf;
import it.neunet.subtitle.usf.styleable.TextElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SrtParser {
	private BufferedReader br;
	private Usf usf;

	public SrtParser(String rawText){
		this.br = new BufferedReader(new StringReader(rawText));
	}
	
	public SrtParser(InputStream is) {
		this.br = new BufferedReader(new InputStreamReader(is));
	}

	public Usf getLastParsedDoc() {
		return usf;
	}

	public Usf parseDoc() {
		usf = new Usf();

		Subtitles subtitles = new Subtitles();
		subtitles.setOwner(usf);

		try {
			String line, subText = null;
			Subtitle sub = null;
			int lineNumber = 0;
			
			while((line = br.readLine()) != null){
				lineNumber++;
				
				if(line.trim().equals("")){
					// a white line means the end of this subtitle
					// so create a new element for this
					TextElement te = new TextElement(subText);
					// add to it the text parsed
					sub.addText(te);
					// and enqueue it
					subtitles.addSubtitle(sub);
					// then reset the aux variables
					lineNumber = 0;
					subText = null;
				} else {
					if(lineNumber == 1){
						// begins a new subtitle
						sub = new Subtitle();
					}else if(lineNumber == 2){
						// parse the duration
						String startString, endString;
						startString = line.split("-->")[0];
						endString = line.split("-->")[1];
						sub.setStartMillisecond(startString);
						sub.setEndMillisecond(endString);
					} else {
						// add text to subtitle
						if(subText == null)
							subText = line;
						// each new line must be separated
						else
							subText += "\n" + line;
					}
				}
			}
			// add the subtitles parsed at the USF's root
			usf.addSubtitle(subtitles);			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return usf;
	}
	
}
