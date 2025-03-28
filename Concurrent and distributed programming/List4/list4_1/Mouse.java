package List4.list4_1;
import java.util.Random;


public class Mouse extends Thread{
    private final Cake cake;


    public Mouse(final Cake cake, final String name) {
        super(name);
        this.cake = cake;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (cake.eat(new Random().nextInt(40)) <= 0) {
                System.out.println("======KONIEC=======");
                break;
            }
        }
    }
}
