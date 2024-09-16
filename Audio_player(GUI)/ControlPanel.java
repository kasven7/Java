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
    // class variables
    private Clip clip;
    private int current_index = 0;
    private boolean was_track_manually_changed = false;
    private boolean can_be_used = false;    // determines whether the buttons can be activated or not
    private boolean was_file_loaded_and_played = false;     // checks whether loadAndPlayCurrentFile function has been called
    private ArrayList<File> audio_files;    // a folder
    private final KButton play_stop_button;
    private final KButton reset_button;
    private final KButton next_track_button;
    private final KButton previous_track_button;
    private final KButton select_folder_button;
    private final KButton forward_track_by_five_seconds_button;
    private final KButton rewind_track_by_five_seconds_button;


    // locate the current file that you're on in the folder and play it
    private void loadAndPlayCurrentFile() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(current_index >= audio_files.size()) {
            current_index = 0;
        }

        was_file_loaded_and_played = true;
        File current_file = audio_files.get(current_index);
        AudioInputStream ais = AudioSystem.getAudioInputStream(current_file);
        clip = AudioSystem.getClip();
        clip.open(ais);

        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                // Ensure the clip is closed properly before starting the next one
                clip.close();

                if(!was_track_manually_changed) {
                    nextTrack();  // Play the next track when the current one ends
                }

                was_track_manually_changed = false;
            }
        });

        clip.start();

    }


    // fills "a folder" with .wav files
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

        else {
            try {
                loadAndPlayCurrentFile();

            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            }

            can_be_used = true;
            updateButtonStates();
        }
    }

    // play a previous track in the folder
    private void previousTrack(ActionEvent actionEvent) {
        was_track_manually_changed = true;

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





    // play the next track in the folder
    private void nextTrack(ActionEvent actionEvent) {
        was_track_manually_changed = true;

        try{
            clip.close();
            current_index++;
            loadAndPlayCurrentFile();

        } catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        }
    }

    private void nextTrack(){
        try{
            clip.close();
            current_index++;
            loadAndPlayCurrentFile();

        }catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        }
    }


    // constructor of control panel
    ControlPanel() {

        // Control panel buttons
        forward_track_by_five_seconds_button = new KButton();
        forward_track_by_five_seconds_button.setText("↻");

        play_stop_button = new KButton();
        play_stop_button.setText("▶▐▐");

        reset_button = new KButton();
        reset_button.setText("⏹");

        next_track_button = new KButton();
        next_track_button.setText("▷");

        previous_track_button = new KButton();
        previous_track_button.setText("◁");

        select_folder_button = getFolderButton();

        rewind_track_by_five_seconds_button = new KButton();
        rewind_track_by_five_seconds_button.setText("↺");


        // Panel properties
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBounds(0, 0, 500, 37);


        // button functionality
        forward_track_by_five_seconds_button.addActionListener(this::forwardTrackByFiveSeconds);
        play_stop_button.addActionListener(_ -> {
            if(was_file_loaded_and_played) {
                clip.stop();
                was_file_loaded_and_played = false;
            }

            else{
                clip.start();
                was_file_loaded_and_played = true;
            }
        });
        reset_button.addActionListener(_ -> clip.setFramePosition(0));
        next_track_button.addActionListener(this::nextTrack);
        previous_track_button.addActionListener(this::previousTrack);
        rewind_track_by_five_seconds_button.addActionListener(this::rewindTrackByFiveSeconds);


        // contents of the panel
        this.add(rewind_track_by_five_seconds_button);
        this.add(previous_track_button);
        this.add(play_stop_button);
        this.add(reset_button);
        this.add(next_track_button);
        this.add(forward_track_by_five_seconds_button);
        this.add(select_folder_button);

        updateButtonStates();
        select_folder_button.setEnabled(true);
    }


    // a function which updates turns the buttons on and off
    private void updateButtonStates(){
        forward_track_by_five_seconds_button.setEnabled(can_be_used);
        play_stop_button.setEnabled(can_be_used);
        reset_button.setEnabled(can_be_used);
        next_track_button.setEnabled(can_be_used);
        previous_track_button.setEnabled(can_be_used);
        rewind_track_by_five_seconds_button.setEnabled(can_be_used);
        select_folder_button.setEnabled(false);
    }


    // forward button logic
    private void forwardTrackByFiveSeconds(ActionEvent actionEvent) {
        if(clip.isRunning() && clip != null) {
            long current_frame_position = clip.getFramePosition();
            AudioFormat format = clip.getFormat();

            long frames_to_move = (long)(5 * format.getFrameRate());
            long new_position = current_frame_position + frames_to_move;

            if(new_position <= clip.getFrameLength()) {
                clip.setFramePosition((int) new_position);
            }

        }
    }


    // rewind button logic
    private void rewindTrackByFiveSeconds(ActionEvent actionEvent) {
        if(clip.isRunning() && clip != null) {
            long current_frame_position = clip.getFramePosition();
            AudioFormat format = clip.getFormat();

            long frames_to_move = (long) (5 * format.getFrameRate());
            long new_position = current_frame_position - frames_to_move;

            if (new_position <= clip.getFrameLength()) {
                clip.setFramePosition((int) new_position);
            }
        }
    }


    // select folder button functionality
    private KButton getFolderButton() {
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