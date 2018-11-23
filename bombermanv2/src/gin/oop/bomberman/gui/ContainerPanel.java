package gin.oop.bomberman.gui;

import gin.oop.bomberman.BombermanGame;

import javax.swing.*;
import java.awt.*;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.sound.Sound;

public class ContainerPanel extends JPanel {

    private static final String TAG_MENU = "tag_menu";
    private static final String TAG_PLAYGAME = "tag_playgame";
    private Menu _menu;
    public PlayPanel _playGame;
    public Game _game;
    private Frame _frame;
    private CardLayout _cardLayout;
    public Sound _sound;
    ContainerPanel(Frame frame) {
        _frame = frame;
        _sound = _frame._sound;
        _cardLayout = new CardLayout();
        setLayout(_cardLayout);
        _menu = new Menu(this);
        _playGame = new PlayPanel(_frame);
        _game = _playGame._gamePanel.getGame();
        add(_menu, TAG_MENU);
        add(_playGame, TAG_PLAYGAME);
        showMenu();
    }
    public void showMenu() {
        _sound.MENU.loop(100);
        _cardLayout.show(ContainerPanel.this, TAG_MENU);
        _menu.requestFocus();

    }
    public void play() {
        _sound.close("MENU");
        _sound.PLAYGAME.loop(100);
        _cardLayout.show(ContainerPanel.this, TAG_PLAYGAME);
        _playGame.requestFocus();

    }

}
