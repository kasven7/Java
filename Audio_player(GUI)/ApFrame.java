import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class ApFrame extends JFrame {

    ApFrame() {

        ControlPanel control_panel = new ControlPanel();

        // frame properties
        this.setTitle("Audio Player");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        // concerning panels
        this.add(control_panel);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                control_panel.setBounds(300, 300, 400, 37);
            }
        });

        this.setVisible(true);

    }
}
