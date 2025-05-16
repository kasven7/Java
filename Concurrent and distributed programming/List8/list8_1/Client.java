package List8.list8_1;

import java.util.concurrent.Exchanger;

public class Client extends Thread{
    private Exchanger<String> exchanger = new Exchanger<String>();
    private String product = "1l of canola oil";


    public Client(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }


    public void run(){
        try{
            System.out.println("Product of Seller: " + product);
            String replacedProduct = product;

            product = exchanger.exchange(product);
            System.out.println("Seller exchanged: " + replacedProduct + " for " + product);
        } catch(InterruptedException e){
            throw new RuntimeException();
        }
    }
}
