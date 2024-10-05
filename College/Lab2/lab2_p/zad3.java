package lab2_p;
import java.util.Random;
import java.util.Scanner;


public class zad3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int enteredNumber;
        int randomNumber = random.nextInt(5) + 1;

        System.out.println("Welcome to Number Guessing Game!");

        do {

            System.out.println("Enter a natural number in 1 to 200 range: ");
            enteredNumber = input.nextInt();

        } while(enteredNumber < 1 || enteredNumber > 200);


        System.out.println("Here is the number drawn: " + randomNumber);

        if(enteredNumber == randomNumber) {
            System.out.println("You guessed the number! Congratulations :)");

        }

        else if(enteredNumber > randomNumber) {
            System.out.println("Your number is greater than the drawn number!");

        }

        else{
            System.out.println("Your number is lesser than the drawn number!");
        }


    }
}
