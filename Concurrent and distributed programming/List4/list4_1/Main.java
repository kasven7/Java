package List4.list4_1;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args){
        Cake cake = new Cake();
        Thread mouse1 = new Mouse(cake, "Mysz_1");
        Thread mouse2 = new Mouse(cake, "Mysz_2");

        System.out.println("mouse1=" + mouse1.getState());
        System.out.println("mouse2=" + mouse2.getState());

        mouse1.start();
        mouse2.start();


        while (true) {
            System.out.println("mouse1=" + mouse1.getState());
            System.out.println("mouse2=" + mouse2.getState());


            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mouse1.getState().ordinal()
                    + mouse2.getState().ordinal() == 10) {
                break;
            }
        }
    }
}


/*
Czy w danym momencie tylko jedna mysz je tort? - w momencie, gdy metoda z synchronizacją jest na myszy,
to dochodzi do sytuacji, że obie myszy jedzą tort jednocześnie. Natomiast, gdy metoda z synchronizacją jest na cieście
to wtedy nie dochodzi do takiej sytuacji, jedna mysz czeka na to aż druga skończy jeść.

Jak brzmi motto synchronizacji? - "Jeśli zapisujesz wartość zmiennej, która może zostać zaraz odczytana przez
inny wątek lub odczytujesz wartość zmiennej, która może właśnie być zapisywana przez inny wątek, to musisz
zastosować synchronizację."
 */