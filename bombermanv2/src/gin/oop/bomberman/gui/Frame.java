package gin.oop.bomberman.gui;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.input.Keyboard;
import gin.oop.bomberman.sound.Sound;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Frame chứa toàn bộ các component
 */
public class Frame extends JFrame {
	




	private Game _game;
	private Keyboard _input;
	public ContainerPanel _containerPanel;
	public Sound _sound;
	public Frame(Sound sound) {
		_sound = sound;
		_containerPanel = new ContainerPanel(this);
		add(_containerPanel);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		startGame();
	}
	public void startGame() {
		_containerPanel._game.start();
	}
	public void pauseGame() {
		_game.getBoard().gamePause();
	}

	public void resumeGame() {
		_game.getBoard().gameResume();
	}
	public void setTime(int time) {
		_containerPanel._playGame._infoPanel.setTime(time);
	}
	
	public void setPoints(int points) {
		_containerPanel._playGame._infoPanel.setPoints(points);
	}





}
