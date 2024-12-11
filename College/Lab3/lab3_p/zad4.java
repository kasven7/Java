package lab3_p;
import java.util.Scanner;


public class zad4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double product = 1.0;
        String input;

        System.out.println("Enter a number (enter 'q' to quit): ");

        while (true) {
            input = in.nextLine();


            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                product *= number;

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Enter \"q\" to quit.");
            }
        }


        System.out.println("The product of given numbers: " + product);
        in.close();
    }
}

