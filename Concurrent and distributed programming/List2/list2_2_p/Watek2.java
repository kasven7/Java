package list2_2_p;


public class Watek2 extends Thread{
    @Override
    public void run(){
        for(int i = 1; i <= 20; i++){
            System.out.println(Thread.currentThread().getName() + " | i = " + i);
        }
    }
}
