package gin.oop.bomberman.gui;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    public GamePanel _gamePanel;
    public InfoPanel _infoPanel;
    public PlayPanel(Frame frame) {
        setLayout(new BorderLayout());
        _gamePanel = new GamePanel(frame);
        _infoPanel = new InfoPanel(_gamePanel.getGame());
        add(_infoPanel, BorderLayout.PAGE_START);
        add(_gamePanel, BorderLayout.PAGE_END);
    }
}
