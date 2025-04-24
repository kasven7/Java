package List5.list5_4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Semaphore semDD = new Semaphore(0);
        Semaphore semDR = new Semaphore(0);
        Data data = new Data(semDD);
        Delta delta = new Delta(data, semDD, semDR);
        Roots roots = new Roots(data, delta, semDR);

        data.start();
        delta.start();
        roots.start();
    }
}
