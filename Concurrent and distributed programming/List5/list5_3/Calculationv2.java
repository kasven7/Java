package List5.list5_3;

import java.util.concurrent.Semaphore;

public class Calculationv2 extends Thread{
    private Data1v2 d1;
    private Data2v2 d2;
    private Semaphore sem1;
    private Semaphore sem2;


    public Calculationv2(Data1v2 d1, Data2v2 d2, Semaphore sem1, Semaphore sem2){
        this.d1 = d1;
        this.d2 = d2;
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            try {
                sem1.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Sum of a and b is equal to " + (d1.getA() + d2.getB()));
            System.out.println("Thread Calculation ends its work");
            sem2.release();
        }
    }
}
