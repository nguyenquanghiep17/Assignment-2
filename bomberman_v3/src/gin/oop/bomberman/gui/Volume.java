package gin.oop.bomberman.gui;

import gin.oop.bomberman.sound.Sound;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Volume extends JPanel {
    private JSlider jSlider;
    private JSlider soundEffect;
    private JLabel jLabel;
    private JLabel soundEffects;
    private JLabel back;
    private JLabel volume;
    private ContainerPanel _containerPanel;
    Volume(ContainerPanel containerPanel) {
        _containerPanel = containerPanel;
        setBackground(Color.BLACK);
        setLayout(null);

        jSlider = new JSlider(JSlider.HORIZONTAL,0 ,100,50);
        jSlider.setPaintTicks(true);
        jSlider.setMajorTickSpacing(25);
        jSlider.setForeground(Color.WHITE);
        jSlider.setBackground(Color.BLACK);
        jSlider.setBounds(250,100,200,50);
        add(jSlider);

        jLabel = new JLabel("Soundtrack: 50%");
        jLabel.setForeground(Color.WHITE);
        jLabel.setBounds(80,110, 150,20);
        add(jLabel);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabel.setText("Soundtrack: " + jSlider.getValue() + "%");
                Sound.soundtackVolume = jSlider.getValue();
                Sound.setSoundtackVolume(_containerPanel._sound.MENU);
                Sound.setSoundtackVolume(_containerPanel._sound.PLAYGAME);
                Sound.setSoundtackVolume(_containerPanel._sound.WIN);
                Sound.setSoundtackVolume(_containerPanel._sound.LOSE);

            }
        });

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

        volume = new JLabel("VOLUME");
        volume.setFont(new Font("Arial", Font.PLAIN, 30));
        volume.setBounds(300,20,200,40);
        volume.setForeground(Color.WHITE);
        add(volume);

        soundEffects = new JLabel("Sound effects: 50%");
        soundEffects.setForeground(Color.WHITE);
        soundEffects.setBounds(80,300, 200,20);
        add(soundEffects);

        soundEffect = new JSlider(JSlider.HORIZONTAL,0 ,100,50);
        soundEffect.setPaintTicks(true);
        soundEffect.setMajorTickSpacing(25);
        soundEffect.setForeground(Color.WHITE);
        soundEffect.setBackground(Color.BLACK);
        soundEffect.setBounds(250,290,200,50);
        add(soundEffect);
        soundEffect.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                soundEffects.setText("Sound effects: " + soundEffect.getValue() + "%");
                Sound.soundEffectVolume = soundEffect.getValue();
                Sound.setSoundEffectVolume(_containerPanel._sound.BOMB);
                Sound.setSoundEffectVolume(_containerPanel._sound.ITEM);
                Sound.setSoundEffectVolume(_containerPanel._sound.BOMB_BANG);
                Sound.setSoundEffectVolume(_containerPanel._sound.MONSTER_DIE);
                Sound.setSoundEffectVolume(_containerPanel._sound.BOMBER_DIE);
            }
        });

    }

    public void backToMenu(MouseEvent e) {
        _containerPanel.showMenu();
    }

}