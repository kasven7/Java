package List7.list7_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Palleter extends Thread {
    private final BlockingQueue<Integer> wrappedQueue;
    private final int identificationCode;
    private static AtomicInteger palletCounter = new AtomicInteger(1);

    public Palleter(String name, BlockingQueue<Integer> wrappedQueue, int identificationCode) {
        super(name);
        this.wrappedQueue = wrappedQueue;
        this.identificationCode = identificationCode;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " (id: " + identificationCode + ") is waiting for wrapped cookies...");

                int cookiesToPallet = 4;
                int[] wrappedCookies = new int[cookiesToPallet];

                for (int i = 0; i < cookiesToPallet; i++) {
                    wrappedCookies[i] = wrappedQueue.take();
                    System.out.println(getName() + " (id: " + identificationCode + ") took wrapped package " + wrappedCookies[i] +
                            " | Wrapped queue: " + wrappedQueue.size());
                }

                int palletNumber = palletCounter.getAndIncrement();
                System.out.println(getName() + " (id: " + identificationCode + ") created pallet #" + palletNumber +
                        " with packages: " + arrayToString(wrappedCookies));

                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted, finishing work.");
            Thread.currentThread().interrupt();
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(array[i]);
        }
        return sb.toString();

    }
}
