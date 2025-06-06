package list10.list10_2;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create and start readers
        int readerCount = 5;
        for (int i = 0; i < readerCount; i++) {
            new Reader(library, i + 1).start();
        }

        // Create and start writers
        int writerCount = 2;
        for (int i = 0; i < writerCount; i++) {
            new Writer(library, i + 1).start();
        }

        System.out.println("Library simulation started with " + readerCount + " readers and " + writerCount + " writers.");
    }
}