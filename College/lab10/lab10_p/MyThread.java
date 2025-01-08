package lab10_p;
import java.time.LocalDate;


public class MyThread implements Runnable{
    LocalDate date;

    @Override
    public void run(){
        for(int i = 1; i <= 15; i++){
            System.out.print("id: " + Thread.currentThread().threadId());
            System.out.println(" thread: " + i + " date: " + date.now());
        }
    }
}
