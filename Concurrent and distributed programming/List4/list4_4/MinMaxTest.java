package List4.list4_4;
import java.util.Random;


public class MinMaxTest {
    public static final int N = 320000000;    // the size of our table of random values
    public static final int W = 500;


    public static void main(String[] args){
        Random rand = new Random();
        MinMaxThreadInt[] minMaxThreadsInt = new MinMaxThreadInt[W];
        MinMaxThreadDouble[] minMaxThreadsDouble = new MinMaxThreadDouble[W];
        int[] iTab = new int[N];
        double[] dTab = new double[N];
        int range = N / W;
        int globalMinValueOfInt = Integer.MAX_VALUE;
        int globalMaxValueOfInt = Integer.MIN_VALUE;
        double globalMinValueOfDouble = Double.MAX_VALUE;
        double globalMaxValueOfDouble = Double.MIN_VALUE;


        // Filling our tables with random values
        for(int i = 0; i < N; i++)
            iTab[i] = rand.nextInt(1000000);

        for(int i = 0; i < N; i++)
            dTab[i] = rand.nextDouble(1000000);

        // INT

        long startPointOfInt = System.nanoTime();    // we measure the point in time from which the min max search for int starts

        // declaring our threads and correctly separating the tasks for these threads to handle and also finding local min and max values
        for(int i = 0; i < minMaxThreadsInt.length; i++){
            int startPos = i * range;   // we count the start position in thread work range
            minMaxThreadsInt[i] = new MinMaxThreadInt(iTab, startPos, (i == minMaxThreadsInt.length - 1) ? N : startPos + range);   // Here we pass the end position and we count it also
            minMaxThreadsInt[i].start();
        }

        // searching for global min and max Values in our iTab of random numbers
        for (MinMaxThreadInt minMaxThreadInt : minMaxThreadsInt) {
            try {
                minMaxThreadInt.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (globalMinValueOfInt > minMaxThreadInt.getMinValue()) globalMinValueOfInt = minMaxThreadInt.getMinValue();
            if (globalMaxValueOfInt < minMaxThreadInt.getMaxValue()) globalMaxValueOfInt = minMaxThreadInt.getMaxValue();
        }

        long endPointOfInt = System.nanoTime();

        System.out.println("INT");
        System.out.println("Min value: " + globalMinValueOfInt + "    |     Max value: " + globalMaxValueOfInt);
        System.out.println("Time: " + (endPointOfInt - startPointOfInt) + "ns");

        long startPointOfDouble = System.nanoTime(); // we measure the point in time from which the min max search for double starts

        for(int i = 0; i < minMaxThreadsDouble.length; i++){
            int startPos = i * range;
            minMaxThreadsDouble[i] = new MinMaxThreadDouble(dTab, startPos, (i == minMaxThreadsInt.length - 1) ? N : startPos + range);
            minMaxThreadsDouble[i].start();
        }

        for (MinMaxThreadDouble minMaxThreadDouble : minMaxThreadsDouble) {
            try {
                minMaxThreadDouble.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (globalMinValueOfInt > minMaxThreadDouble.getMinValue()) globalMinValueOfDouble = minMaxThreadDouble.getMinValue();
            if (globalMaxValueOfInt < minMaxThreadDouble.getMaxValue()) globalMaxValueOfDouble = minMaxThreadDouble.getMaxValue();
        }

        long endPointOfDouble = System.nanoTime(); // we measure the point in time from which the min max search for double ends

        System.out.println("DOUBLE");
        System.out.println("Min value: " + globalMinValueOfDouble + "    |     Max value: " + globalMaxValueOfDouble);
        System.out.println("Time: " + (endPointOfDouble - startPointOfDouble) + "ns");
    }
}
