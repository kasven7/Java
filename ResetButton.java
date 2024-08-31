import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class ResetButton extends JButton{
    ResetButton() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        File file = new File("antent - hope to see you again (slowed).wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(ais);

        this.setText("RESET");
        this.setForeground(Color.GREEN);
        this.setBackground(Color.BLACK);
        this.setBorderPainted(false);

        this.addActionListener(_ -> clip.setFramePosition(0));

    }
}
