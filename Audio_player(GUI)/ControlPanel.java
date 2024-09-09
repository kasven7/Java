import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.sound.sampled.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ControlPanel extends JPanel {
    private Clip clip;
    private int current_index = 0;
    private boolean is_folder_loaded_and_played = false;
    private boolean is_folder_selected = false;
    private ArrayList<File> audio_files;
    private final KButton stop_button;
    private final KButton next_track_button;
    private final KButton previous_track_button;


    // locate the current file that you're on in the folder and play it
    private void loadAndPlayCurrentFile() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        if(current_index >= audio_files.size()) {
            current_index = 0;
        }

        if(is_folder_loaded_and_played) {
            clip.close();
            is_folder_loaded_and_played = false;
        }

        is_folder_loaded_and_played = true;
        File current_file = audio_files.get(current_index);
        AudioInputStream ais = AudioSystem.getAudioInputStream(current_file);
        clip = AudioSystem.getClip();
        clip.open(ais);
        clip.start();
    }

    // simulate a folder
    private void loadAudioFiles(String path) {
        File directory = new File(path);
        audio_files = new ArrayList<>();

        for(File file : Objects.requireNonNull(directory.listFiles())) {
            if(file.getName().endsWith(".wav")) {
                audio_files.add(file);
            }
        }

        if(audio_files.isEmpty()){
            JOptionPane.showMessageDialog(null, "No \".wav\" files found in the specified directory!");
        }

        if(!audio_files.isEmpty()) {
            is_folder_selected = true;
        }

    }

    // play a previous track in the folder
    private void previousTrack(ActionEvent actionEvent) {

        if(is_folder_loaded_and_played) {
            try{

                clip.close();
                current_index--;

                if(current_index < 0) {
                    current_index = audio_files.size() - 1;
                }

                loadAndPlayCurrentFile();

            } catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
                e.printStackTrace();
            }
        }

        else{
            JOptionPane.showMessageDialog(null, "Please select a folder in which you hold your \".wav\" audio files first!");
        }
    }


    // play the next track in the folder
    private void nextTrack(ActionEvent actionEvent) {
        if(is_folder_loaded_and_played) {
            try{
                clip.close();
                current_index++;
                loadAndPlayCurrentFile();

            } catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
                e.printStackTrace();
            }
        }

        else{
            JOptionPane.showMessageDialog(null, "Please select a folder in which you hold your \".wav\" audio files first!");
        }
    }


    // constructor of control panel
    ControlPanel() {

        // Control panel buttons
        KButton play_button = new KButton();
        play_button.setText("➤⏹");

        stop_button = new KButton();
        stop_button.setText("❚❚");

        next_track_button = new KButton();
        next_track_button.setText(">>>");

        previous_track_button = new KButton();
        previous_track_button.setText("<<<");


        KButton select_folder_button = getKButton();


        // Panel properties
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(300, 300, 400, 37);


        // button functionality
        play_button.addActionListener(_ -> {
            if(is_folder_selected) {
                try{
                    loadAndPlayCurrentFile();
                    updateButtonStates();

                }catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
                    e.printStackTrace();
                }
            }

            else{
                JOptionPane.showMessageDialog(null, "Please select a folder in which you hold your \".wav\" audio files first!");
            }

        });

        stop_button.addActionListener(_ -> {
            if(is_folder_selected) {
                clip.stop();
            }

            else{
                JOptionPane.showMessageDialog(null, "Please select a folder in which you hold your \".wav\" audio files first!");
            }
            });
        next_track_button.addActionListener(this::nextTrack);
        previous_track_button.addActionListener(this::previousTrack);

        this.add(previous_track_button);
        this.add(play_button);
        this.add(stop_button);
        this.add(next_track_button);
        this.add(select_folder_button);
      
        updateButtonStates();
    }

    // updates the states of buttons after the user has selected a folder
    private void updateButtonStates(){

        stop_button.setEnabled(is_folder_selected);
        next_track_button.setEnabled(is_folder_selected);
        previous_track_button.setEnabled(is_folder_selected);

    }


    private KButton getKButton() {
        KButton select_folder_button = new KButton();
        select_folder_button.setText("Select a folder");
        select_folder_button.addActionListener(_ -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Files", "wav");

            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setFileFilter(filter);

            int response = chooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                File selected_directory = chooser.getSelectedFile();
                loadAudioFiles(selected_directory.getAbsolutePath());

            }
        });
        return select_folder_button;
    }
}