package gin.oop.bomberman.gui;

import gin.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tutorial extends JPanel {
    private ContainerPanel _containerPanel;
    private JLabel back;
    private JLabel tutorial;
    private JLabel backGround;
    private ImageIcon _image = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\icon\\keyboard.png");
    Tutorial(ContainerPanel containerPanel) {

        _containerPanel= containerPanel;
        setLayout(null);
        setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
        this.imageUpdate(_image.getImage(),0,0,0,725,666);
        backGround = new JLabel();
        backGround.setBounds(0, 0, 725, 666);
        backGround.setBackground(Color.BLACK);
        backGround.setIcon(_image);
        back = new JLabel("BACK");
        back.setFont(new Font("Arial", Font.PLAIN, 30));
        back.setBounds(550,600,120,40);
        back.setForeground(Color.WHITE);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backToMenu(e);
            }
        });

        add(back);

        tutorial = new JLabel("TUTORIAL");
        tutorial.setFont(new Font("Arial", Font.PLAIN, 30));
        tutorial.setBounds(300,20,200,40);
        tutorial.setForeground(Color.WHITE);
        add(tutorial);
        add(backGround);

    }
    private void backToMenu(MouseEvent e) {
        _containerPanel.showMenu();
    }
}
