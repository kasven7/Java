package lab3_p;
import java.util.Scanner;


public class zad5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a natural number: ");
        int number = in.nextInt();

        if(number < 0){
            System.out.println("You cannot enter negative numbers!");
        }

        else{
            System.out.println("Here are all the powers of three less than the given number: ");
            for(int i = 1; i < number; i *= 3){
                System.out.print(i + "  ");
            }
        }
        in.close();
    }
}
