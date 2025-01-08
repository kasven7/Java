package lab10_p;


public class Zad2 {
    public static void main(String[] args){
        Thread logGenerator1 = new Thread(new MovieLogGenerator1());
        logGenerator1.start();

        try {
            logGenerator1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MovieLogGenerator2 logReader = new MovieLogGenerator2();
        logReader.start();
    }
}
