package List7.list7_1;

import java.util.concurrent.BlockingQueue;

public class Packer extends Thread{
    private final BlockingQueue<Integer> cookieQue;


    public Packer(String name, BlockingQueue<Integer> cookieQue){
        super(name);
        this.cookieQue = cookieQue;
    }

    public void run(){
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is waiting for the cookie...");
                Integer cookie = cookieQue.take();

                System.out.println(Thread.currentThread().getName() + " has taken a cookie from the product track " + cookie + " |  track: " + cookieQue.size() + "/" + cookieQue.remainingCapacity());
                Thread.sleep(2000);
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
