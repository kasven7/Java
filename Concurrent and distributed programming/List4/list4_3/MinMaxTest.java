package List4.list4_3;
import java.util.Random;


public class MinMaxTest {
    public static final int N = 320000000;    // the size of our table of random values
    public static final int W = 8;


    public static void main(String[] args){
        Random rand = new Random();
        MinMaxThread[] minMaxThreads = new MinMaxThread[W];
        int[] tab = new int[N];
        // double[] tab2 = new tab[N];
        int range = N / minMaxThreads.length;
        int globalMinValue = Integer.MAX_VALUE;
        int globalMaxValue = Integer.MIN_VALUE;


        // Filling our tab with random values
        for(int i = 0; i < N; i++){
            tab[i] = rand.nextInt(100);
        }

        long startPoint = System.nanoTime();    // we measure the point in time from which the min max search starts

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
1. Czy czas działania programu zmienia się w zależności od liczby wątków?
Tak, czas działania programu zmienia się w zależności od liczby wątków.
Przy większej liczbie wątków olbiczenia mogą być wykonywane równolegle, co przyspiesza działanie programu.
Jednak po przekroczeniu liczby rdzeni procesora istnieje ryzyko, że dodatkowe wątki wprowadzą narzut związany
z przełączaniem kontekstu, co może powodować spowolnienie zamiast przyspieszenia.

2.Jaki jest czas działania programu dla 1, 2, 4, 6 i 8 wątków?
Dla 1 wątku: 108358700ns
Dla 2 wątków: 147326900ns
Dla 4 wątków: 109882200ns
Dla 6 wątków: 104327000ns
Dla 8 wątków: 102307500ns

Rozmiar tablicy z liczbami: 320000000

3. Jaka jest zależność czasu działania programu i liczby rdzeni procesora w komputerze?
Przy 1 wątku program działa sekwencyjnie – brak przyspieszenia.

Przy 2, 4, 6, 8 wątkach – program powinien działać szybciej, ale tylko do momentu osiągnięcia liczby rdzeni fizycznych.

Po przekroczeniu 8 wątków, zysk wydajności może być mniejszy, ponieważ wątki zaczynają współdzielić rdzenie (SMT).

Wartością graniczną dla optymalnej wydajności jest 8 wątków, ponieważ odpowiada liczbie rdzeni.


Specyfikacja sprzętu:
    a) procesor: 12th Gen Intel(R) Core(TM) i5-12500H   2.50 GHz, 8-rdzeniowy,
    b) system operacyjny: Windows 11 Home,
    c) rozmiar pamięci RAM: 16GB
*/