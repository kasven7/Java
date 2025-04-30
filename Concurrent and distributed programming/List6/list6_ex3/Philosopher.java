package List6.list6_ex3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private final int id;
    private final String name;
    private final Semaphore leftFork;
    private final Semaphore rightFork;
    private final Semaphore queue;
    private final Random fate = new Random();

    public Philosopher(int id, String name, Semaphore leftFork, Semaphore rightFork, Semaphore queue) {
        this.id = id;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.queue = queue;
    }

    private void think() throws InterruptedException {
        System.out.println(id + ". " + name + " is thinking.");
        Thread.sleep(fate.nextInt(1000) + 500);
    }

    private void eat() throws InterruptedException {
        System.out.println(id + ". " + name + " is eating.");
        Thread.sleep(fate.nextInt(1000) + 500);
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                System.out.println(id + ". " + name + " is waiting.");
                queue.acquire();
                System.out.println(id + ". " + name + " wants to eat.");

                leftFork.acquire();
                System.out.println(id + ". " + name + " picked up left fork.");

                rightFork.acquire();
                System.out.println(id + ". " + name + " picked up right fork.");

                eat();

                rightFork.release();
                System.out.println(id + ". " + name + " put down right fork.");

                leftFork.release();
                System.out.println(id + ". " + name + " put down left fork.");

                queue.release();
            }
        } catch (InterruptedException e) {
            System.out.println(id + "." + name + " was interrupted.");
        }
    }
}