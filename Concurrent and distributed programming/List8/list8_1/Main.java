package List8.list8_1;
/* use synchronised list in ex 2
* Use Executor for turning threads on
*
* */


import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args){
        Exchanger<String> exchanger = new Exchanger<String>();

        new Client(exchanger).start();
        new Seller(exchanger).start();
    }
}
