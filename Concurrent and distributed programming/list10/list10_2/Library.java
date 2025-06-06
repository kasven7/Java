package list10.list10_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Library {
    private int readersCount = 0;
    private boolean writerActive = false;
    private final Lock lock = new ReentrantLock();
    private final Condition canRead = lock.newCondition();
    private final Condition canWrite = lock.newCondition();
    private String content = "Initial library content";

    public void startReading() throws InterruptedException {
        lock.lock();
        try {
            while (writerActive) {
                canRead.await();
            }
            readersCount++;
            System.out.println("Reader started. Total readers: " + readersCount);
        } finally {
            lock.unlock();
        }
    }

    public void endReading() {
        lock.lock();
        try {
            readersCount--;
            System.out.println("Reader finished. Remaining readers: " + readersCount);
            if (readersCount == 0) {
                canWrite.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void startWriting() throws InterruptedException {
        lock.lock();
        try {
            while (readersCount > 0 || writerActive) {
                canWrite.await();
            }
            writerActive = true;
            System.out.println("Writer started writing.");
        } finally {
            lock.unlock();
        }
    }

    public void endWriting() {
        lock.lock();
        try {
            writerActive = false;
            System.out.println("Writer finished writing.");
            canRead.signalAll();
            canWrite.signal();
        } finally {
            lock.unlock();
        }
    }

    public String readContent() {
        return content;
    }

    public void writeContent(String newContent) {
        this.content = newContent;
    }
}