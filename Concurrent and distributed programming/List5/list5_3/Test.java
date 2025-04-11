package List5.list5_3;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args){
        Semaphore semData1 = new Semaphore(1);
        Semaphore semData2 = new Semaphore(0);
        Semaphore semCalculation = new Semaphore(0);
        Data1v2 d1 = new Data1v2(semData1, semData2);
        Data2v2 d2 = new Data2v2(semData2, semCalculation);
        Calculationv2 calculation = new Calculationv2(d1, d2, semCalculation, semData1);

        d1.start();
        d2.start();
        calculation.start();
    }
}
