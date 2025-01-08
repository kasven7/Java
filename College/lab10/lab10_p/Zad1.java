package lab10_p;


public class Zad1 {

    public static void main(String[] args){
        MyThread myThread1 = new MyThread();
        Thread thread1 = new Thread(myThread1);

        thread1.start();
    }
}
