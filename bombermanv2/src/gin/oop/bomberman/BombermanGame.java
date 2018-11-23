package gin.oop.bomberman;

import gin.oop.bomberman.gui.Frame;
import gin.oop.bomberman.sound.Sound;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BombermanGame {

	public static void main(String[] args)  {
		Sound sound = new Sound();
		new Frame(sound);
	}


}
