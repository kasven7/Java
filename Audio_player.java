import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class Audio_player {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner sc = new Scanner(System.in);

        File file = new File("antent - hope to see you again (slowed).wav");

        AudioInputStream audio_stream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();

        clip.open(audio_stream);

        String response = "";

        while(!(response.equals("Q"))) {

            System.out.println("P = play,\nS = stop,\nR = reset,\nQ = quit");
            System.out.print("Enter your choice: ");
            response = sc.next();
            response = response.toUpperCase();


            switch(response){

                case "P": clip.start(); break;
                case "S": clip.stop(); break;
                case "R": clip.setFramePosition(0); break;
                case "Q":  clip.close(); break;
                default: System.out.println("Invalid choice");

            }
        }
        System.out.println("You have exited the program. Have a nice day :)");
    }
}
