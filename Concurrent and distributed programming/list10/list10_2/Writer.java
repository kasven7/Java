package list10.list10_2;

import java.util.Random;

public class Writer extends Thread {
    private final Library library;
    private final int writerId;
    private final Random random = new Random();
    private int writeCount = 0;

    public Writer(Library library, int writerId) {
        this.library = library;
        this.writerId = writerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Simulate some activity before writing
                Thread.sleep(random.nextInt(3000) + 2000);

                library.startWriting();
                try {
                    // Writing new content
                    String newContent = "New content from writer " + writerId + " (" + (++writeCount) + ")";
                    library.writeContent(newContent);
                    System.out.println("Writer " + writerId + " wrote: " + newContent);
                    Thread.sleep(random.nextInt(1500) + 1000); // Simulate writing time
                } finally {
                    library.endWriting();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Writer " + writerId + " was interrupted.");
        }
    }
}