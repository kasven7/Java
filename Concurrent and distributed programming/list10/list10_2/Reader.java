package list10.list10_2;

import java.util.Random;

public class Reader extends Thread {
    private final Library library;
    private final int readerId;
    private final Random random = new Random();

    public Reader(Library library, int readerId) {
        this.library = library;
        this.readerId = readerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Simulate some activity before reading
                Thread.sleep(random.nextInt(2000) + 1000);

                library.startReading();
                try {
                    // Reading the content
                    String content = library.readContent();
                    System.out.println("Reader " + readerId + " read: " + content);
                    Thread.sleep(random.nextInt(1000) + 500); // Simulate reading time
                } finally {
                    library.endReading();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Reader " + readerId + " was interrupted.");
        }
    }
}