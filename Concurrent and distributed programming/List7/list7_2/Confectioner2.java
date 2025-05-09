package List7.list7_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Confectioner2 extends Thread{
    private final BlockingQueue<Integer> cookieQue;
    private static AtomicInteger serialNum = new AtomicInteger(1);
    private final int identificationCode;


    public Confectioner2(String name, BlockingQueue<Integer> cookieQue, int identificationCode){
        super(name);
        this.cookieQue = cookieQue;
        this.identificationCode = identificationCode;
    }

    public void run(){
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " is mixing a cookie");
                Integer id = serialNum.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " has made cookie " + id);
                cookieQue.put(id);

                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " has put a cookie onto the product track " + id);
                Thread.sleep(1500);
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
