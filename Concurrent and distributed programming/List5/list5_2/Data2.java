package List5.list5_2;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data2 extends Thread{
    private int b;
    private Semaphore semD;
    private Semaphore semDC;

    Data2(Semaphore semD, Semaphore semDC){
        this.semD = semD; this.semDC = semDC;
    }

    @Override
    public void run(){
        try {
            semD.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Enter b: ");
        b = in.nextInt();

        System.out.println("Thread Data2 ends its work");
        semDC.release();
    }

    public int getB(){return b;}
}
