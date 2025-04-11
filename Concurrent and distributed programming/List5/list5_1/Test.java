package List5.list5_1;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args){
        Semaphore sem = new Semaphore(0);
        Data data = new Data(sem);
        Calculation calc = new Calculation(data, sem);

        data.start();
        calc.start();
    }
}
