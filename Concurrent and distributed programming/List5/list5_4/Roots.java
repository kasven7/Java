package List5.list5_4;

import java.util.concurrent.Semaphore;

public class Roots extends Thread{
    private double x1;
    private double x2;
    private Data data;
    private Delta delta;
    private Semaphore sem;

    public Roots(Data data, Delta delta, Semaphore sem){
        this.data = data;
        this.delta = delta;
        this.sem = sem;
    }

    @Override
    public void run(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(Math.sqrt(delta.getDelta()) > 0){
            x1 = (-data.getB() - Math.sqrt(delta.getDelta())) / (2 * data.getA());
            x2 = (-data.getB() + Math.sqrt(delta.getDelta())) / (2 * data.getA());
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }

        else if(Math.sqrt(delta.getDelta()) == 0){
            x1 = -data.getB() / (2 * data.getA());
            System.out.println("x = " + x1);
        }

        else{
            System.out.println("An equation has no roots");
        }

        System.out.println("End of calculations");
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }
}
