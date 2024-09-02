import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class ControlPanel extends JPanel {

    ControlPanel() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        // File clip and audio input stream
        File file = new File("antent - hope to see you again (slowed).wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(ais);

        // Control panel buttons
        KButton play = new KButton();
        play.setText("PLAY");

        KButton stop = new KButton();
        stop.setText("STOP");

        KButton reset = new KButton();
        reset.setText("RESET");

        // Panel properties
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(300, 300, 250, 37);

        // button functionality
        play.addActionListener(_ -> clip.start());
        stop.addActionListener(_ -> clip.stop());
        reset.addActionListener(_ -> clip.setFramePosition(0));

        this.add(play);
        this.add(stop);
        this.add(reset);

    }
}
