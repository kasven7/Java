package lab10_p;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class MovieLogGenerator1 implements Runnable {
    @Override
    public void run(){
        Random rand = new Random();



        try(BufferedWriter writer = new BufferedWriter(new FileWriter("movie_logs.txt", true))){
            for(int i = 0; i < 70; i++) {
                int movieId = rand.nextInt(200) + 1;
                int userId = rand.nextInt(200) + 1 + 200;
                double rating = 1 + (5 - 1) * rand.nextDouble(5);
                MovieLog movieLog = new MovieLog(movieId, userId, rating);
                writer.write(movieLog.toString());
                writer.newLine();
            }
        }   catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
