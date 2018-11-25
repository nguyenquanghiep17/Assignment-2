package gin.oop.bomberman.gui;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.input.Keyboard;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

/**
 * Swing Panel chứa cảnh game
 */
public class GamePanel extends JPanel {

	private Game _game;
	private JLabel exit;
	private JLabel newGame;
	private JLabel backToMenu;
	private Frame _frame;
	public GamePanel(Frame frame) {
		_frame = frame;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
		ImageIcon newGameIcon = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\icon\\newgame.png");
		newGame = new JLabel();
		newGame.setBounds(290,400,174,33);
		newGame.setFont(new Font("Arial", Font.PLAIN, 40));
		newGame.setForeground(Color.BLACK);
		newGame.setIcon(newGameIcon);
		newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				hidden();
				_frame.newGame();
				hidden();
			}
		});
		ImageIcon backToMenuIcon = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\icon\\backtomenu.png");
		backToMenu = new JLabel();
		backToMenu.setBounds(290,460,230,31);
		backToMenu.setFont(new Font("Arial", Font.PLAIN, 40));
		backToMenu.setForeground(Color.BLACK);
		backToMenu.setIcon(backToMenuIcon);
		backToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hidden();
				_frame._containerPanel._game.getBoard().resetProperties();
				hidden();
				_frame._containerPanel.showMenu();
				hidden();
			}
		});

		ImageIcon exitIcon = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\icon\\exit.png");
		exit = new JLabel();
		exit.setBounds(290,520,69,28);
		exit.setFont(new Font("Arial", Font.PLAIN, 40));
		exit.setForeground(Color.BLACK);
		exit.setIcon(exitIcon);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.exit(0);
			}
		});
		this.add(exit);
		this.add(newGame);
		this.add(backToMenu);
		_game = new Game(frame);

		add(_game);

		_game.setVisible(true);

		setVisible(true);
		setFocusable(true);

		hidden();
	}

	public Game getGame() {
		return _game;
	}

	public void display() {
		newGame.setVisible(true);
		exit.setVisible(true);
		backToMenu.setVisible(true);
	}
	public void hidden() {
		newGame.setVisible(false);
		backToMenu.setVisible(false);
		exit.setVisible(false);

	}


}
