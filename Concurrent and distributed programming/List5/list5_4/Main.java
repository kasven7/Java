package List5.list5_4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Semaphore sem = new Semaphore(0);
        Data data = new Data(sem);
        Delta delta = new Delta(data, sem);
        Roots roots = new Roots(data, delta, sem);

        data.start();
        delta.start();
        roots.start();
    }
}
