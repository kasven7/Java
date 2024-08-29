import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class ApFrame extends JFrame{

    ApFrame() {

        ControlPanel control_panel = new ControlPanel();

        this.setTitle("Audio Player");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        this.add(control_panel);
        this.getContentPane().setBackground(Color.BLACK);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                control_panel.setBounds(300, 300, 250, 37);
            }
        });

        this.setVisible(true);

    }
}
