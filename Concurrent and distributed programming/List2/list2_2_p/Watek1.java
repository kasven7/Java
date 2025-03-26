package list2_2_p;

import java.util.concurrent.TimeUnit;

public class Watek1 extends Thread{
    @Override
    public void run(){
        for(int i = 1; i <= 20; i++){
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " | i = " + i);
        }
    }
}
