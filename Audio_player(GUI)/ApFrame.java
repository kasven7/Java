import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;


public class ApFrame extends JFrame {

    ApFrame() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        ControlPanel control_panel = new ControlPanel();
        FolderChooserPanel chooser_panel = new FolderChooserPanel();

        // frame properties
        this.setTitle("Audio Player");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        // concerning panels
        this.add(control_panel);
        this.add(chooser_panel);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                control_panel.setBounds(300, 300, 300, 37);
                chooser_panel.setBounds(395, 340, 110, 37);
            }
        });

        this.setVisible(true);

    }
}
