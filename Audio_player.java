import javax.sound.sampled.*;
import java.io.IOException;
import java.io.File;



class Audio_player {

    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        File file = new File("antent - hope to see you again (slowed).wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(ais);


        ApFrame apFrame = new ApFrame();

    }
}