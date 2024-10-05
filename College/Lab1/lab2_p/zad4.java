package lab2_p;
import java.util.Scanner;


public class zad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers;
        int product = 1;

        do{
            System.out.println("Enter an integer: ");
            numbers = sc.nextInt();
            product *= numbers;

        } while(numbers != 5);
        System.out.println("The product of entered numbers is equal to " + product);
    }
}
