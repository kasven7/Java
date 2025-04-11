package List5.list5_2;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data1 extends Thread{
    private int a;
    private Semaphore sem;

    Data1(Semaphore sem){
        this.sem = sem;
    }

    @Override
    public void run(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a: ");
        a = in.nextInt();

        System.out.println("Thread Data1 ends its work");
        sem.release();
    }

    public int getA() {return a;}
}
