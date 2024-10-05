package lab2_p;
import java.util.Scanner;


public class zad1 {

    static boolean isNumberPrime(int number){
        if(number < 2){
            return false;

        }


        for(int i = 2; i < Math.sqrt(number); i++){
            if(number % i == 0){
                return false;

            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int number = input.nextInt();


        double proportionOfMeans = getProportionOfMeans(number);


        System.out.println("The number you have entered: " + number);
        System.out.println("The proportion of means of even and odd numbers in the given number equals: " + proportionOfMeans);

        if(isNumberPrime(number)){
            System.out.println("The number " + number + " is a prime number");

        }

        else{
            System.out.println("The number \"" + number + "\" is not a prime number");
        }

    }

    private static double getProportionOfMeans(int number) {
        int sumOfEvenNumbers = 0;
        int counterOfEvenNumbers = 0;
        int sumOfOddNumbers = 0;
        int counterOfOddNumbers = 0;
        int temporaryNumber = number;
        double meanOfEvenNumbers;
        double meanOfOddNumbers;
        double proportionOfMeans;


        while(temporaryNumber > 0){
            int digit = temporaryNumber % 10;


            if(digit % 2 == 0){
                sumOfEvenNumbers += digit;
                counterOfEvenNumbers++;
            }

            else{
                sumOfOddNumbers += digit;
                counterOfOddNumbers++;
            }

            temporaryNumber /= 10;
        }

        meanOfEvenNumbers = (double) sumOfEvenNumbers / counterOfEvenNumbers;
        meanOfOddNumbers = (double) sumOfOddNumbers / counterOfOddNumbers;
        proportionOfMeans = meanOfOddNumbers / meanOfEvenNumbers;
        return proportionOfMeans;
    }


}
