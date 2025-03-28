package list3_1;


public class LicznikWatkow {
    private int wartoscKrytyczna;


    public synchronized int policzMnie() throws InterruptedException {
        wartoscKrytyczna += 1;
        wartoscKrytyczna--;
        return wartoscKrytyczna;
    }
}