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
    private JLabel sound;
    private JLabel tutorial;
    private ImageIcon _image = new ImageIcon("D:\\bomberman-starter-starter-project-1\\res\\textures\\logo.jpg");


    Menu(ContainerPanel containerPanel) {
        _containerPanel = containerPanel;

        setLayout(null);

        setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
        this.imageUpdate(_image.getImage(),0,0,0,725,666);

        backGround = new JLabel();
        backGround.setBounds(0, 0, 725, 666);
        backGround.setBackground(Color.BLACK);
        backGround.setIcon(_image);


        start = new JLabel("NEW GAME");
        start.setBounds(300,400,250,40);
        start.setFont(new Font("Arial", Font.PLAIN, 30));
        start.setForeground(Color.WHITE);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play(e);
            }
        });

        sound = new JLabel("SOUND");
        sound.setBounds(300,460,250,40);
        sound.setFont(new Font("Arial", Font.PLAIN, 30));
        sound.setForeground(Color.WHITE);
        sound.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sound(e);
            }
        });

        exit = new JLabel("EXIT");
        exit.setBounds(300,580,100,40);
        exit.setFont(new Font("Arial", Font.PLAIN, 30));
        exit.setForeground(Color.WHITE);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        tutorial = new JLabel("TUTORIAL");
        tutorial.setBounds(300,520,250,40);
        tutorial.setFont(new Font("Arial", Font.PLAIN, 30));
        tutorial.setForeground(Color.WHITE);
        tutorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tutorial(e);
            }
        });

        add(start);
        add(sound);
        add(exit);
        add(tutorial);
        add(backGround);


    }
    private void play(MouseEvent e) {

        _containerPanel.play();
    }

    private void tutorial(MouseEvent e) {
        _containerPanel.showTutorial();
    }

    private void sound(MouseEvent e) {
        _containerPanel.showSound();
    }


}


