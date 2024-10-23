package lab2_p;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class zad4 {
    public static void main(String[] args) {
        List<Integer> xAmountOfNumbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int sum = 0;
        char choice;


        do{

            System.out.println();
            System.out.println("Enter an integer: ");
            int number = input.nextInt();
            xAmountOfNumbers.add(number);
            sum += number;

            System.out.println("Do you want to quit? (enter \"y\" in order to terminate): ");
            choice = input.next().charAt(0);

        } while(choice != 'y' && choice != 'Y');


        int minValue = Collections.min(xAmountOfNumbers);
        int maxValue = Collections.max(xAmountOfNumbers);
        double meanOfXNumbers = (double) sum / xAmountOfNumbers.size();

        System.out.println("Min = " + minValue);
        System.out.println("Max = " + maxValue);
        System.out.println("Mean = " +  meanOfXNumbers);
        System.out.println("Count of entered integers = " + xAmountOfNumbers.size());

        input.close();
    }
}

