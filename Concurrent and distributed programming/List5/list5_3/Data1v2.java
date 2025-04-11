package List5.list5_3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data1v2 extends Thread{
    private int a;
    private Semaphore sem1;
    private Semaphore sem2;

    Data1v2(Semaphore sem1, Semaphore sem2){
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i ++){
            try {
                sem1.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Scanner in = new Scanner(System.in);

            System.out.println("Enter a: ");
            a = in.nextInt();

            System.out.println("Thread Data1 ends its work");
            sem2.release();
        }

    }

    public int getA() {return a;}
}
