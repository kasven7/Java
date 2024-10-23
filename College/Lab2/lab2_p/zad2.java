package lab3_p;
import java.util.Scanner;


public class zad2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = in.nextInt();

        System.out.println("Here are your number's divisors: ");
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.print(i + "   ");
            }
        }

        in.close();
    }
}
