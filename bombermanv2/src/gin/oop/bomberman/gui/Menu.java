package gin.oop.bomberman.gui;


import gin.oop.bomberman.Game;
import gin.oop.bomberman.sound.Sound;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends JPanel {
    private ContainerPanel _containerPanel;

    private JLabel start;
    private JLabel exit;
    private JLabel backGround;
    private ImageIcon _image = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\textures\\logo.jpg");

    private Sound _sound;
    Menu(ContainerPanel containerPanel) {
        _containerPanel = containerPanel;
        _sound = _containerPanel._sound;
        setLayout(null);

        setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
        this.imageUpdate(_image.getImage(),0,0,0,725,666);

        backGround = new JLabel();
        backGround.setBounds(0, 0, 725, 666);
        backGround.setBackground(Color.BLACK);
        backGround.setIcon(_image);


        start = new JLabel("Start");
        start.setBounds(320,400,200,40);
        start.setFont(new Font("Arial", Font.PLAIN, 40));
        start.setForeground(Color.WHITE);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                click(e);
            }
        });


        exit = new JLabel("Exit");
        exit.setBounds(320,500,100,40);
        exit.setFont(new Font("Arial", Font.PLAIN, 40));
        exit.setForeground(Color.WHITE);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        add(start);
        add(exit);
        add(backGround);
    }
    private void click(MouseEvent e) {
        _containerPanel.play();
    }


}


