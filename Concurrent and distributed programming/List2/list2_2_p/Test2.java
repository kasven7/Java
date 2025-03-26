package list2_2_p;

public class Test2 {
    public static void main(String[] args){
        W1 w1 = new W1();
        W2 w2 = new W2();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        System.out.println("KONIEC PROGRAMU");
    }
}
