package List5.list5_4;

import java.util.concurrent.Semaphore;

public class Delta extends Thread{
    private Data data;
    private Semaphore sem;
    private double delta;

    public Delta(Data data, Semaphore sem) {this.data = data; this.sem = sem;}

    @Override
    public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        delta = Math.pow(data.getB(), 2) - (4 * data.getA() * data.getC());
        System.out.println("Delta has been calculated");
        sem.release();
    }

    public double getDelta() {
        return delta;
    }
}
