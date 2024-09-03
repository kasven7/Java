import javax.swing.*;
import java.awt.*;
 on-going
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import java.io.File;
import java.io.IOException;
 main
import javax.sound.sampled.*;


public class ControlPanel extends JPanel {
    private Clip clip;
    private int current_index = 0;
    private ArrayList<File> audio_files;

on-going

    // locate the current file that you're on in the folder and play it
    private void loadAndPlayCurrentFile() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(current_index >= audio_files.size()) {
            current_index = 0;
        }

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
    }

    // play a previous track in the folder
    private void previousTrack(ActionEvent actionEvent) {
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
        try{
            clip.close();
            current_index++;
            loadAndPlayCurrentFile();

        } catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        }
    }


    // constructor of control panel
    ControlPanel() {

        loadAudioFiles("E:\\Pobrane pliki\\Audio_player_folder");


        // Control panel buttons
        KButton play_button = new KButton();
        play_button.setText("PLAY");

        KButton stop_button = new KButton();
        stop_button.setText("STOP");

        KButton reset_button = new KButton();
        reset_button.setText("RESET");

        KButton next_track_button = new KButton();
        next_track_button.setText(">>>");

        KButton previous_track_button = new KButton();
        previous_track_button.setText("<<<");

=======
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
main

        // Panel properties
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
on-going
        this.setBounds(300, 300, 400, 37);

        // button functionality
        play_button.addActionListener(_ -> {
            try{
                loadAndPlayCurrentFile();
            }catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
                e.printStackTrace();
            }
        });

        stop_button.addActionListener(_ -> clip.stop());
        reset_button.addActionListener(_ -> clip.setFramePosition(0));
        next_track_button.addActionListener(this::nextTrack);
        previous_track_button.addActionListener(this::previousTrack);


        this.add(play_button);
        this.add(stop_button);
        this.add(reset_button);
        this.add(next_track_button);
        this.add(previous_track_button);
=======
        this.setBounds(300, 300, 250, 37);

        // button functionality
        play.addActionListener(_ -> clip.start());
        stop.addActionListener(_ -> clip.stop());
        reset.addActionListener(_ -> clip.setFramePosition(0));

        this.add(play);
        this.add(stop);
        this.add(reset);
main

    }
}