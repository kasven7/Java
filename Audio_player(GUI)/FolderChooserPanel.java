import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FolderChooserPanel extends JPanel {

    FolderChooserPanel() {

        KButton select_folder_button = new KButton();
        select_folder_button.setText("Select folder");

        this.setBackground(Color.black);
        this.add(select_folder_button);
        this.setBounds(395, 340, 110, 40);


    }
}
