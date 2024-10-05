package lab1_p;
import java.util.Scanner;


public class zad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double minNumber = Double.MAX_VALUE;
        double maxNumber = Double.MIN_VALUE;


        System.out.println("Enter the amount of numbers you would like to use in your calculations: ");
        int amountOfNumbers = sc.nextInt();


        for(int i = 0; i < amountOfNumbers; i++){
            System.out.println("Enter a real number: ");
            double number = sc.nextDouble();


            if(number < minNumber){
                minNumber = number;
            }

            if(number > maxNumber){
                maxNumber = number;
            }

            sum += number;

        }

        System.out.println("Min value = " + minNumber);
        System.out.println("Max value = " + maxNumber);
        System.out.println("Average of given numbers = " + sum / amountOfNumbers);
        System.out.println("The amount of entered numbers = " + amountOfNumbers);
    }
}

