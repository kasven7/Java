package List5.list5_2;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args){
        Semaphore semD = new Semaphore(0);
        Semaphore semDC = new Semaphore(0);
        Data1 d1 = new Data1(semD);
        Data2 d2 = new Data2(semD, semDC);
        Calculation calculation = new Calculation(d1, d2, semDC);

        d1.start();
        d2.start();
        calculation.start();
    }
}
