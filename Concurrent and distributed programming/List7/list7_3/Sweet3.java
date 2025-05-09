package List7.list7_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Sweet3 {
    public static void main(String[] args) {
        final int COOKIE_QUEUE_CAPACITY = 10;
        final int WRAPPED_QUEUE_CAPACITY = 5;
        final int CONFECTIONERS = 3;
        final int PACKERS = 2;
        final int PALLETERS = 2;

        BlockingQueue<Integer> cookieQueue = new ArrayBlockingQueue<>(COOKIE_QUEUE_CAPACITY);
        BlockingQueue<Integer> wrappedQueue = new ArrayBlockingQueue<>(WRAPPED_QUEUE_CAPACITY);
        Confectioner3[] confectioners = new Confectioner3[CONFECTIONERS];
        Packer3[] packers = new Packer3[PACKERS];
        Palleter[] palleters = new Palleter[PALLETERS];


        for (int i = 0; i < CONFECTIONERS; i++) {
            confectioners[i] = new Confectioner3("Confectioner", cookieQueue, i);
            confectioners[i].start();
        }

        for (int i = 0; i < PACKERS; i++) {
             packers[i] = new Packer3("Packer", cookieQueue, wrappedQueue, i);
             packers[i].start();
        }

        for (int i = 0; i < PALLETERS; i++) {
            palleters[i] = new Palleter("Palleter", wrappedQueue, i);
            palleters[i].start();
        }
    }
}
