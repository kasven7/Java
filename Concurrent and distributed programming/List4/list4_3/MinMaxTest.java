package List4.list4_3;
import java.util.Random;


public class MinMaxTest {
    public static final int N = 320000000;    // the size of our table of random values


    public static void main(String[] args){
        Random rand = new Random();
        MinMaxThread[] minMaxThreads = new MinMaxThread[2];
        int[] tab = new int[N];
        int range = N / minMaxThreads.length;
        long startPoint = System.nanoTime();    // we measure the point in time from which the min max search starts
        int globalMinValue = Integer.MAX_VALUE;
        int globalMaxValue = Integer.MIN_VALUE;


        // Filling our tab with random values
        for(int i = 0; i < N; i++){
            tab[i] = rand.nextInt(100);
        }


        // declaring our threads and correctly separating the tasks for these threads to handle and also finding local min and max values
        for(int i = 0; i < minMaxThreads.length; i++){
            int startPos = i * range;   // we count the start position in thread work range
            minMaxThreads[i] = new MinMaxThread(tab, startPos, (i == minMaxThreads.length - 1) ? N : startPos + range);   // Here we pass the end position and we count it also
            minMaxThreads[i].start();
        }


        // searching for global min and max Values in our tab of random numbers
        for (MinMaxThread minMaxThread : minMaxThreads) {
            try {
                minMaxThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (globalMinValue > minMaxThread.getMinValue()) globalMinValue = minMaxThread.getMinValue();
            if (globalMaxValue < minMaxThread.getMaxValue()) globalMaxValue = minMaxThread.getMaxValue();
        }

        long endPoint = System.nanoTime();
        
        System.out.println("Min value: " + globalMinValue + "    |     Max value: " + globalMaxValue);
        System.out.println("Time: " + (endPoint - startPoint) + "ns");
    }
}

/*

* */
