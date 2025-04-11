package List5.list5_4;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data extends Thread{
    private double a;
    private double b;
    private double c;
    private Semaphore sem;

    public Data(Semaphore sem){this.sem = sem;}

    @Override
    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = in.nextInt();

        System.out.println("Enter b: ");
        b = in.nextInt();

        System.out.println("Enter c: ");
        c = in.nextInt();

        System.out.println("Data for square equation has been gathered");
        sem.release();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
