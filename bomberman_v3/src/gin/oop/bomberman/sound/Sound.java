package gin.oop.bomberman.sound;


import com.sun.scenario.Settings;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


import javax.sound.sampled.*;



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
    public static int soundtackVolume = 75;
    public static int soundEffectVolume = 75;
    private AudioInputStream _sound;
    public Sound() {
        putAudio();

    }
    public static void setSoundtackVolume(Clip clip) {
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = control.getMinimum();
            float result = range * (1 - soundtackVolume / 100.0f);
            control.setValue(result);
    }
    public static void setSoundEffectVolume(Clip clip) {
        FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float range = control.getMinimum();
        float result = range * (1 - soundEffectVolume / 100.0f);
        control.setValue(result);
    }




    public void putAudio() {

        try {

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\menu.wav"));
            MENU = AudioSystem.getClip();
            MENU.open(_sound);
            setSoundtackVolume(MENU);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\playgame.wav"));
            PLAYGAME = AudioSystem.getClip();
            PLAYGAME.open(_sound);
            setSoundtackVolume(PLAYGAME);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\newbomb.wav"));
            BOMB = AudioSystem.getClip();
            BOMB.open(_sound);
            setSoundEffectVolume(BOMB);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\bomber_die.wav"));
            BOMBER_DIE = AudioSystem.getClip();
            BOMBER_DIE.open(_sound);
            setSoundEffectVolume(BOMBER_DIE);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\monster_die.wav"));
            MONSTER_DIE = AudioSystem.getClip();
            MONSTER_DIE.open(_sound);
            setSoundEffectVolume(MONSTER_DIE);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\bomb_bang.wav"));
            BOMB_BANG = AudioSystem.getClip();
            BOMB_BANG.open(_sound);
            setSoundEffectVolume(BOMB_BANG);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\item.wav"));
            ITEM = AudioSystem.getClip();
            ITEM.open(_sound);
            setSoundEffectVolume(ITEM);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\win.wav"));
            WIN = AudioSystem.getClip();
            WIN.open(_sound);
            setSoundtackVolume(WIN);

            _sound = AudioSystem.getAudioInputStream(new File("res\\sound\\lose.wav"));
            LOSE = AudioSystem.getClip();
            LOSE.open(_sound);
            setSoundtackVolume(LOSE);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }


    public  void play(String name){
        switch (name) {
            case "MENU":
                setSoundtackVolume(MENU);
                MENU.start();
                break;
            case "PLAYGAME":
                setSoundtackVolume(PLAYGAME);
                PLAYGAME.start();
                break;
            case "BOMB":
                setSoundEffectVolume(BOMB);
                BOMB.start();
                break;
            case "BOMB_BANG":
                setSoundEffectVolume(BOMB_BANG);
                BOMB_BANG.start();
                break;
            case "BOMBER_DIE":
                setSoundEffectVolume(BOMBER_DIE);
                BOMBER_DIE.start();
                break;
            case "MONSTER_DIE":
                setSoundEffectVolume(MONSTER_DIE);
                MONSTER_DIE.start();
                break;
            case "WIN":
                setSoundtackVolume(WIN);
                WIN.start();
                break;
            case "LOSE":
                setSoundtackVolume(LOSE);
                LOSE.start();
                break;
            case "ITEM":
                setSoundEffectVolume(ITEM);
                ITEM.start();
                break;
        }
    }
    public  void close(String name){
        switch (name) {
            case "MENU":
                MENU.close();
                break;
            case "PLAYGAME":
                PLAYGAME.close();
                break;
        }
    }
    public void pause(String name){
        switch (name) {
            case "MENU":
                MENU.stop();
                break;
            case "PLAYGAME":
                PLAYGAME.stop();
                break;
        }
    }


}
