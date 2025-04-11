package List5.list5_2;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data2 extends Thread{
    private int b;

    private Semaphore sem;

    Data2(Semaphore sem){
        this.sem = sem;
    }

    @Override
    public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Enter b: ");
        b = in.nextInt();

        System.out.println("Thread Data2 ends its work");
        sem.release();
    }

    public int getB(){return b;}
}
