import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * This class is utilized to read the audio files present and begin and loop the tracks when called. 
 * Credit to RyiSnow on youtube for basic tutorial.
 */
		
public class Sound extends JFrame{
			
	Clip bgm;
	Clip flip;

	/**
	 * takes the string with the audio clip location and instantiates the bgm with lower sound -10 decimals. 
	 * @param soundFileName string containing the audio file
	 */
	
	public void setbgmFile(String soundFileName) {
		
		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			bgm = AudioSystem.getClip();
			bgm.open(sound);
			FloatControl reduceVolume = (FloatControl) bgm.getControl(FloatControl.Type.MASTER_GAIN);
			reduceVolume.setValue(-10.0f); 
		}
		catch(Exception e) {
			
		}
	}
	
	/**
	 * takes the string with the audio clip location and instantiates the flip audio with higher sound +50 decimals. 
	 * @param soundFileName string containing the audio file
	 */
	
	public void setTileFile(String soundFileName) {
		
		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			flip = AudioSystem.getClip();
			flip.open(sound);
			FloatControl increaseVolume = (FloatControl) flip.getControl(FloatControl.Type.MASTER_GAIN);
			increaseVolume.setValue(+50.0f); 
		}
		catch(Exception e) {
			
		}
	}
	
	/**
	 * takes a clip argument and plays the track once from the beginning
	 * @param type of clip for either bgm or click noise 
	 */
	
	public void play(Clip type) {
		type.setFramePosition(0);
		type.start();
	}
	
	/**
	 * takes a clip argument and plays the track continuously
	 * @param type of clip for either bgm or click noise 
	 */
	public void loop(Clip type) {
		type.loop(Clip.LOOP_CONTINUOUSLY);
	}
	

}	
