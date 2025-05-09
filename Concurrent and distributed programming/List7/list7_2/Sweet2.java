package List7.list7_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Sweet2 {
    public static void main(String[] args){
        final int C = 7;
        final int CONFECTIONERS = 3;
        final int PACKERS = 2;

        BlockingQueue<Integer> cookieQue = new ArrayBlockingQueue<>(C);
        Confectioner2[] confectioners = new Confectioner2[CONFECTIONERS];
        Packer2[] packers = new Packer2[PACKERS];

        for(int i = 0; i < CONFECTIONERS; i++){
            confectioners[i] = new Confectioner2("Confectioner", cookieQue, i);
            confectioners[i].start();
        }

        for(int i = 0; i < PACKERS; i++){
            packers[i] = new Packer2("Packer", cookieQue, i);
            packers[i].start();
        }
    }
}
