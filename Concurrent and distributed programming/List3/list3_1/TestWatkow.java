package list3_1;


public class TestWatkow {
    public static void main(String[] args) {
        int tnum = Integer.parseInt(args[0]); // liczba wątków
        int count = Integer.parseInt(args[1]); // liczba powtórzeń pętli w run()

// Tworzymy obiekt klasy balance
        LicznikWatkow licznik = new LicznikWatkow();

// Tworzymy i uruchamiamy wątki
        WatekLiczacy[] thread = new WatekLiczacy[tnum]; // tablica wątków
        for (int i = 0; i < tnum; i++)
            thread[i] = new WatekLiczacy("Watek" + (i + 1), licznik, count);

// czekaj na zakończenie wszystkich wątków
        try {
            for (int i = 0; i < tnum; i++) {thread[i].join();}
        } catch (InterruptedException exc) { System.exit(1); }
        System.out.println("Koniec programu");
    }
}

/* the amount of ones depends on the value of count the higher it is the higher the chance of returning 1.
Thread.sleep() between increment and decrement values - one thread waits and the other increments itself therefore the values will be more than 1
when we add synchronized keyword to policzMnie() then the runtime is longer, with different values of count every time the program returns 0 it no longer returns 1 or any other value
 */
