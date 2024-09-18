import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class KButton extends JButton {

    KButton() {

        Border empty_border = BorderFactory.createEmptyBorder();

        // properties of my buttons
        this.setForeground(Color.GREEN);
        this.setBackground(Color.BLACK);
        this.setBorder(empty_border);
        this.setBorderPainted(false);
        this.setFont(new Font("Serif", Font.PLAIN, 20));

    }
}
