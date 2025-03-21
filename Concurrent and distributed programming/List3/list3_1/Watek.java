package lab3_1;


public class Watek extends Thread{
    public void run(){
        int runTime = (int) Math.floor((Math.random() % 100)) + 1;

        try {
            Thread.sleep(runTime);
        }
        catch (InterruptedException e) {
                throw new RuntimeException(e);
        }

        for(int i = 1; i<=10; i++)
            System.out.println(Thread.currentThread().getName() + " | i = " + i);

    }
}
