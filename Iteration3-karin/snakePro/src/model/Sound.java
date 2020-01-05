package model;

import java.io.Serializable;
import java.net.URISyntaxException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Sound  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media sound;
	private MediaPlayer audio;

	private Media soundEat;
	private MediaPlayer audioEat;
	/**
	 * The default sound constructor. Initializes the media objects
	 * @throws URISyntaxException if bad file path
	 */
	public Sound() throws URISyntaxException {
		
		// getting the music file from Ressources directory
		sound = new Media(getClass().getResource("/Ressources/Music.mp3").toURI().toString());
		// initializing media player with the music
		audio = new MediaPlayer(sound);
		
		// getting the music file from Ressources directory
		soundEat = new Media(getClass().getResource("/Ressources/EatFruit.mp3").toURI().toString());
		// initializing media player with the music
		audioEat = new MediaPlayer(soundEat);
	}
	
	public MediaPlayer getAudioEat() {
		return audioEat;
	}


	/**
	 * Return the object that handles the music
	 * @return The MediaPlayer object audio
	 */
	public MediaPlayer getAudio() {
		return audio;
	}
}
