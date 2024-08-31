import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.*;


public class ControlPanel extends JPanel {

    ControlPanel() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        PlayButton play = new PlayButton();
        StopButton stop = new StopButton();
        ResetButton reset = new ResetButton();
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        this.add(play);
        this.add(stop);
        this.add(reset);
        this.setBounds(300, 300, 250, 37);


    }
}
