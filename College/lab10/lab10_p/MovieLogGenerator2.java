package lab10_p;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MovieLogGenerator2 extends Thread {
    @Override
    public void run(){
        try (BufferedReader reader = new BufferedReader(new FileReader("movie_logs.txt"))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
                if (lineCount % 10 == 0) {
                    System.out.println("Press Enter to continue...");
                    System.in.read(); // Wait for user input to continue
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
