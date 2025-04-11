package List5.list5_2;

import java.util.concurrent.Semaphore;

public class Calculation extends Thread{
    Data1 d1;
    Data2 d2;
    Semaphore sem;


    public Calculation(Data1 d1, Data2 d2, Semaphore sem){
        this.d1 = d1;
        this.d2 = d2;
        this.sem = sem;
    }

    @Override
    public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sum of a and b is equal to " + (d1.getA() + d2.getB()));
        System.out.println("Thread Calculation ends its work");
    }
}
