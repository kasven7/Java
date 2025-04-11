package List5.list5_1;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data extends Thread{
    private int a;
    private int b;
    private Semaphore sem;

    public Data(Semaphore sem){
        this.sem = sem;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a: ");
        a = sc.nextInt();

        System.out.println("Enter b: ");
        b = sc.nextInt();

        System.out.println("End of data thread's work");
        sem.release();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
