package lab10_p;
import java.time.LocalDate;


public class MovieLog {
    private int movieId;
    private int userId;
    private double rating;
    private String voteDate;


    public MovieLog(int movieId, int userId, double rating){
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
        this.voteDate = LocalDate.now().toString();
    }

    @Override
    public String toString(){
        return "movie id: " + movieId + "," + "user id: " + userId + "," + "rating: " + rating + "," + "voting date: " + voteDate;
    }
}
