package lab3_p;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class zad1 {
    static boolean isNumberPrime(int number) {
        if(number < 2){
            return false;

        }

        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    static double calculateMean(List<Integer> numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return ((double)sum / numbers.size());
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> evenDigits = new ArrayList<>();
        double meanOfEven;
        double meanOfOdd;
        List<Integer> oddDigits = new ArrayList<>();
        int number;


        System.out.println("Enter a number: ");
        String string = in.nextLine();

        for(int i = 0; i < string.length(); i++){
            int num = Integer.parseInt(string.substring(i, i + 1));

            if(num % 2 == 0){
                evenDigits.add(num);
            }

            else{
                oddDigits.add(num);
            }
        }

        meanOfEven = calculateMean(evenDigits);
        meanOfOdd = calculateMean(oddDigits);

        System.out.println("Mean of even digits: " + meanOfEven);
        System.out.println("Mean of odd digits: " + meanOfOdd);
        System.out.println("Proportion of means: " + meanOfOdd + ":" + meanOfEven);

        number = Integer.parseInt(string);
        if(isNumberPrime(number)){
            System.out.println(number + " is a prime number!");
        }

        in.close();
    }
}
