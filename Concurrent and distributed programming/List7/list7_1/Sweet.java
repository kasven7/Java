package List7.list7_1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Sweet {
    public static void main(String[] args){
        final int C = 7;

        BlockingQueue<Integer> que = new ArrayBlockingQueue<>(C);

        new Confectioner("Confectioner", que).start();
        new Packer("Packer", que).start();
    }
}
