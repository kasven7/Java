package List7.list7_1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Confectioner extends Thread{
    private final BlockingQueue<Integer> cookieQue;
    private static AtomicInteger serialNum = new AtomicInteger(1);


    public Confectioner(String name, BlockingQueue<Integer> cookieQue){
        super(name);
        this.cookieQue = cookieQue;
    }

    public void run(){
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is mixing a cookie");
                Integer id = serialNum.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " has made cookie " + id);
                cookieQue.put(id);

                System.out.println(Thread.currentThread().getName() + " has put a cookie onto the product track " + id);
                Thread.sleep(1500);
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
