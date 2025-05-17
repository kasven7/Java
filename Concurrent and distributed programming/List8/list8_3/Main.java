package List8.list8_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        final int N = 185;
        final int THREADNUMBER = 4;
        List<Integer> numbers = new ArrayList<>();

        for(int i = 2; i <= N; i++){
            numbers.add(i);
        }


        // for a single thread
        SingleThreadPrimeFinder singleThreadPrimeFinder = new SingleThreadPrimeFinder(numbers);


        System.out.println("Single Threaded prime numbers: ");

        long startTime = System.nanoTime();
        singleThreadPrimeFinder.start();

        try {
            singleThreadPrimeFinder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();

        System.out.println("Search time for single thread: " + (endTime - startTime) + " ms");

        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<MultiThreadPrimeFinder> tasks = new ArrayList<>();
        List<Integer> allPrimes = new ArrayList<>();

        int chunkSize = numbers.size() / threadCount;
        startTime = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadCount - 1) ? numbers.size() : start + chunkSize;
            tasks.add(new MultiThreadPrimeFinder(numbers, start, end));
        }

        List<Future<Void>> futures = new ArrayList<>();
        for (MultiThreadPrimeFinder task : tasks) {
            futures.add(executor.submit(task, null));
        }

        for (Future<Void> future : futures) {
            future.get();
        }

        for (MultiThreadPrimeFinder task : tasks) {
            allPrimes.addAll(task.getPrimes());
        }

        executor.shutdown();
        endTime = System.nanoTime();

        System.out.println("Search time for 4 threads: " + (endTime - startTime));
        printPrimes(allPrimes);

        System.out.println("Do tables of primes match?: " + singleThreadPrimeFinder.getPrimes().equals(allPrimes));
    }

    public static void printPrimes(List<Integer> primes){
        int count = 0;

        System.out.print("{");
        for(Integer prime : primes){
            System.out.print(prime);
            count++;

            if(count != primes.size()){
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
    }
}

/*
* The speed of execution depends on the content of the table the more elements the table has the faster
*  it will be executed by 4 threads up to a 100 single thread is faster over a 100 it may differ, but when a table
*  has few hundred numbers in it then the 4 thread solution will be much faster  */
