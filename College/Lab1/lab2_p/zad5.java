package lab2_p;
import java.util.Scanner;


public class zad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        do {
            System.out.println("Enter a natural number: ");
            number = sc.nextInt();

            if(number < 0){
                System.out.println("You have to enter a positive number!");
            }

        }while(number < 0);

        System.out.println("Here are all power 3 values that are less than the given number");
        for(int i = 3; i < number; i *= 3){
            System.out.print(i + ", ");
        }
    }
}
