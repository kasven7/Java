package list3_2;


public class Watek extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Hello "+ Thread.currentThread().getName() + "!");
        }
    }
}
