package List4.list4_1;


import java.util.concurrent.TimeUnit;

public class Cake {
    public int percent = 100;


    public synchronized int eat(int percent) {
        System.out.println(Thread.currentThread()
                .getName() + " jem " + percent + " torta.");
        this.percent = Math.max(this.percent - percent, 0);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()
                .getName() + " zostało " + this.percent + " torta.");
        return this.percent;
    }

}