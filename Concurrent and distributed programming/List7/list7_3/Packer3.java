package List7.list7_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Packer3 extends Thread{
    private final BlockingQueue<Integer> cookieQueue;
    private final BlockingQueue<Integer> wrappedQueue;
    private final int identificationCode;
    private static AtomicInteger packageCounter = new AtomicInteger(1);

    public Packer3(String name, BlockingQueue<Integer> cookieQueue,
                  BlockingQueue<Integer> wrappedQueue, int identificationCode) {
        super(name);
        this.cookieQueue = cookieQueue;
        this.wrappedQueue = wrappedQueue;
        this.identificationCode = identificationCode;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " (id: " + identificationCode + ") is waiting for cookies...");

                int cookie1 = cookieQueue.take();
                int cookie2 = cookieQueue.take();

                System.out.println(getName() + " (id: " + identificationCode + ") took cookies: " +
                        cookie1 + " and " + cookie2 + " | Cookie queue: " + cookieQueue.size());

                int packageNumber = packageCounter.getAndIncrement();
                wrappedQueue.put(packageNumber);

                System.out.println(getName() + " (id: " + identificationCode + ") created wrapped package #" + packageNumber +
                        " with cookies: " + cookie1 + ", " + cookie2 +
                        " | Wrapped queue: " + wrappedQueue.size());

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }
}
