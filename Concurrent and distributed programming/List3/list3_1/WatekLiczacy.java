package list3_1;


public class WatekLiczacy extends Thread {
    private LicznikWatkow licznikWatkow;
    private int count;


    public WatekLiczacy(String name, LicznikWatkow licznikWatkow, int count){
        super(name);
        this.licznikWatkow = licznikWatkow;
        this.count = count;
        start();
    }

    public void run() {
        int wynik = 0;

    // W pętli wielokrotnie wywołujemy metodę policzMnie()
    // Jeżeli wynik metody jest różny od zera - przerywamy działanie pętli
        for (int i = 0; i < count; i++) {
            try {
                wynik = licznikWatkow.policzMnie();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (wynik != 0) break;
        }

    // Pokazujemy wartość zmiennej wynik na wyjściu z metody run()
        System.out.println(Thread.currentThread().getName()
                + " konczy z wynikiem " + wynik);
    }
}