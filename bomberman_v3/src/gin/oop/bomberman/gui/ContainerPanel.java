package gin.oop.bomberman.gui;

import gin.oop.bomberman.BombermanGame;

import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import java.awt.*;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.sound.Sound;

public class ContainerPanel extends JPanel {

    private static final String TAG_MENU = "tag_menu";
    private static final String TAG_PLAYGAME = "tag_playgame";
    private static final String TAG_VOLUME = "tag_volume";
    private static final String TAG_TUTORIAL = "tag_tutorial";
    private Menu _menu;
    public PlayPanel _playGame;
    public Game _game;
    public Frame _frame;
    public Volume _volume;
    public Tutorial _tutorial;
    private CardLayout _cardLayout;
    public Sound _sound = new Sound();
    private boolean check = true;
    ContainerPanel(Frame frame) {
        _frame = frame;

        _cardLayout = new CardLayout();
        setLayout(_cardLayout);
        _menu = new Menu(this);
        _volume = new Volume(this);
        _tutorial = new Tutorial(this);
        _playGame = new PlayPanel(_frame);
        _game = _playGame._gamePanel.getGame();
        add(_menu, TAG_MENU);
        add(_playGame, TAG_PLAYGAME);
        add(_volume,TAG_VOLUME);
        add(_tutorial, TAG_TUTORIAL);
        showMenu();
    }
    public void showMenu() {

        _cardLayout.show(ContainerPanel.this, TAG_MENU);
        _menu.requestFocus();

    }
    public void play() {
        _game.getBoard().resetProperties();
        _game.getBoard().newGame();
        _playGame.requestFocus();
        _playGame._gamePanel.hidden();
        _cardLayout.show(ContainerPanel.this, TAG_PLAYGAME);

    }
    public void showSound() {
        Sound.setSoundtackVolume(_sound.MENU);
        _sound.close("PLAYGAME");
        _sound.MENU.loop(Clip.LOOP_CONTINUOUSLY);
        _volume.requestFocus();
        _cardLayout.show(ContainerPanel.this, TAG_VOLUME);

    }
    public void showTutorial() {
        Sound.setSoundtackVolume(_sound.MENU);
        _sound.close("PLAYGAME");
        _sound.MENU.loop(Clip.LOOP_CONTINUOUSLY);
        _tutorial.requestFocus();
        _cardLayout.show(ContainerPanel.this, TAG_TUTORIAL);
    }


}
