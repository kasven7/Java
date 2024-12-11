package lab3_p;
import java.util.Random;
import java.util.Scanner;


public class zad3 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int randomNum = rand.nextInt(200) + 1;
        System.out.println("Random value: " + randomNum);
        boolean guessed = false;


        System.out.println("WELCOME TO NUMBER GUESSING GAME!");
        System.out.println("Pick a natural number in 1 to 200 range: ");
        do{
            int number = in.nextInt();


            if(number == randomNum) {
                System.out.println("YOU'VE WON! CONGRATULATIONS! :)");
                guessed = true;
            }

            else if(number > randomNum) {
                System.out.println("You missed! Your number is greater than the number picked.");
            }

            else if(number < randomNum) {
                System.out.println("You missed! Your number is less than the number picked.");
            }

        }while(!guessed);
        in.close();
    }
}
