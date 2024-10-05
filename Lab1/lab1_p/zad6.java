package lab1_p;
import java.util.Scanner;


public class zad6 {

    static double countMonthlyLeasingRate(double capital, double numberOfRates){
        double interestRate = 0.0;


        if(numberOfRates >= 0 && numberOfRates <= 24){
            interestRate = 0.02;
        }

        if(numberOfRates >= 24 && numberOfRates <= 48){
            interestRate = 0.03;
        }

        if(numberOfRates >= 48 && numberOfRates <= 60){
            interestRate = 0.04;
        }

        if(numberOfRates >= 60 && numberOfRates <= 72){
            interestRate = 0.05;
        }

        if(numberOfRates >= 72 && numberOfRates <= 96){
            interestRate = 0.06;
        }

        else{
            System.out.println("I'm sorry but the number of rates cannot be less than 0 nor greater than 96 rates...");
            System.exit(-1);
        }


        double monthlyInterestRate = interestRate / 12;
        double monthlyLeasingRate = (capital * monthlyInterestRate) / (1 - (Math.pow(1 + monthlyInterestRate, -numberOfRates)));

        return Math.round(monthlyLeasingRate * 100) / 100.0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double capital;
        double numberOfRates;


        do{

            System.out.println("Enter the value of your capital(only up to 300 000 PLN): ");
            capital = input.nextInt();

            System.out.println("Enter the amount of interest rates(up to 96 rates): ");
            numberOfRates = input.nextInt();

            if((capital < 0 || capital > 300000) || (numberOfRates < 0 || numberOfRates > 96)){
                System.out.println("You can only enter a capital in range of 0 to 300000 PLN!");
                System.out.println("The amount of interest rates you entered can only be between 0 to 96 rates!");

            }

        } while((capital < 0 || capital > 300000) || (numberOfRates < 0 || numberOfRates > 96));


        double monthlyLeasingRate = countMonthlyLeasingRate(capital, numberOfRates);
        System.out.println("The monthly leasing payment is equal to " + monthlyLeasingRate + "PLN");
    }
}
