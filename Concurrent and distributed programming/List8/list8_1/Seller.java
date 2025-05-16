package List8.list8_1;

import java.util.concurrent.Exchanger;

public class Seller extends Thread{
    private Exchanger<String> exchanger = new Exchanger<String>();
    private String money = "10 zł";


    public Seller(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }


    public void run(){
        try{
            System.out.println("Client's money before exchange: " + money);
            String moneyCopy = money;

            money = exchanger.exchange(money);
            System.out.println("Client exchanged his money " +  moneyCopy + " for " + money);
        } catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
    }
