package gin.oop.bomberman.sound;


import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {


    public Clip MENU;
    public Clip PLAYGAME;
    public Clip BOMB;
    public Clip BOMBER_DIE;
    public Clip MONSTER_DIE;
    public Clip BOMB_BANG;
    public Clip ITEM;
    public Clip WIN;
    public Clip LOSE;

    AudioInputStream _sound;
    public Sound() {
        putAudio();
    }

    public void putAudio() {

        try {
            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\menu.wav"));
            MENU = AudioSystem.getClip();
            MENU.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\playgame.wav"));
            PLAYGAME = AudioSystem.getClip();
            PLAYGAME.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\newbomb.wav"));
            BOMB = AudioSystem.getClip();
            BOMB.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\bomber_die.wav"));
            BOMBER_DIE = AudioSystem.getClip();
            BOMBER_DIE.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\monster_die.wav"));
            MONSTER_DIE = AudioSystem.getClip();
            MONSTER_DIE.open(_sound);
            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\bomb_bang.wav"));
            BOMB_BANG = AudioSystem.getClip();
            BOMB_BANG.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\item.wav"));
            ITEM = AudioSystem.getClip();
            ITEM.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\win.wav"));
            WIN = AudioSystem.getClip();
            WIN.open(_sound);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\lose.wav"));
            LOSE = AudioSystem.getClip();
            LOSE.open(_sound);


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }


    public void play(String name){
        switch (name) {
            case "MENU":
                MENU.start();
                break;
            case "PLAYGAME":
                PLAYGAME.start();
                break;
            case "BOMB":
                BOMB.start();
                break;
            case "BOMB_BANG":
                BOMB_BANG.start();
                break;
            case "BOMBER_DIE":
                BOMBER_DIE.start();
                break;
            case "MONSTER_DIE":
                MONSTER_DIE.start();
                break;
            case "WIN":
                WIN.start();
                break;
            case "LOSE":
                LOSE.start();
                break;
            case "ITEM":
                ITEM.start();
                break;
        }
    }
    public void close(String name){
        switch (name) {
            case "MENU":
                MENU.close();
                break;
            case "PLAYGAME":
                PLAYGAME.start();
                break;
        }
    }
    public void pause(String name){
        switch (name) {
            case "PLAYGAME":
                PLAYGAME.start();
                break;
        }
    }
}
