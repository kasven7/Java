package lab2_p;
import java.util.Scanner;


public class zad2 {

    static void displayNumberDivisors(int number){
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.print("+-" + i + ", ");
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Enter an integer: ");
        int number = in.nextInt();

        System.out.println("Here are your numbers divisors: ");
        displayNumberDivisors(number);


    }
}
