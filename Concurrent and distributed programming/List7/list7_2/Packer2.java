package List7.list7_2;

import java.util.concurrent.BlockingQueue;

public class Packer2 extends Thread{
    private final BlockingQueue<Integer> cookieQue;
    private final int identificationCode;


    public Packer2(String name, BlockingQueue<Integer> que, int identificationCode){
        super(name);
        this.cookieQue = que;
        this.identificationCode = identificationCode;
    }

    public void run(){
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " is waiting for the cookie...");
                Integer cookie = cookieQue.take();

                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " has taken a cookie from the product track " + cookie + " |  track: " + cookieQue.size() + "/" + cookieQue.remainingCapacity());
                Thread.sleep(2000);
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
