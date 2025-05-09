package List7.list7_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Confectioner3 extends Thread{
    private final BlockingQueue<Integer> que;
    private static AtomicInteger serialNum = new AtomicInteger(1);
    private final int identificationCode;


    public Confectioner3(String name, BlockingQueue<Integer> que, int identificationCode){
        super(name);
        this.que = que;
        this.identificationCode = identificationCode;
    }

    public void run(){
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " is mixing a cookie");
                Integer id = serialNum.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " has made cookie " + id);
                que.put(id);

                System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " has put a cookie onto the product track " + id);
                Thread.sleep(1500);
            }
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " (id code: " + identificationCode + ") " + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
