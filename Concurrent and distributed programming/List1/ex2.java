import java.util.Scanner;


public class ex2 {
    public static boolean isPrime(int number){
        if(number < 2){
            return false;
        }

        for(int i = 2; i<= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number(a natural number): ");
        int number = in.nextInt();

        if(isPrime(number)){
            System.out.println("The number " + number + " is a prime number");
        }

        else{
            System.out.println("The number " + number + " is not a prime number");
        }
    }
}
