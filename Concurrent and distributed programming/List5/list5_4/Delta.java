package List5.list5_4;

import java.util.concurrent.Semaphore;

public class Delta extends Thread{
    private Data data;
    private Semaphore semDD;
    private Semaphore semDR;
    private double delta;

    public Delta(Data data, Semaphore semDD, Semaphore semDR) {this.data = data; this.semDD = semDD; this.semDR = semDR;}

    @Override
    public void run(){
        try {
            semDD.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        delta = Math.pow(data.getB(), 2) - (4 * data.getA() * data.getC());
        System.out.println("Delta has been calculated");
        semDR.release();
    }

    public double getDelta() {
        return delta;
    }
}
