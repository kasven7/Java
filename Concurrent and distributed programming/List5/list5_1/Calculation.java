package List5.list5_1;

import java.util.concurrent.Semaphore;

public class Calculation extends Thread {
    private Data data;
    private Semaphore sem;


    public Calculation(Data d, Semaphore sem){
        this.data = d;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sum of a and b is equal to " + (data.getA() + data.getB()));
    }
}
