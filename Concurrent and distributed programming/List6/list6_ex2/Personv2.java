package List6.list6_ex2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Personv2 extends Thread{
    private final String name;
    private final Semaphore sem;
    private final Random rand = new Random();


    public Personv2(String name, Semaphore sem){
        this.name = name;
        this.sem = sem;
    }

    private void usePhone() throws InterruptedException {
        System.out.println(name + " wants to use the phone");
        sem.acquire();
        System.out.println(name + " is having a phone call");
        Thread.sleep(rand.nextInt(1000));
        System.out.println(name + " ended using the phone");
        sem.release();
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(name + " is reading a book");
            System.out.println(name + " is drinking tea");

            try {
                usePhone();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + " is working on his computer");
        }
    }
}
