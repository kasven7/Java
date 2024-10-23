package lab2_p;
import java.util.Scanner;


public class zad6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter the value of your capital(300 0000PLN at most and 1PLN at least): ");
        double capital = input.nextDouble();

        System.out.println("Enter the car's value: ");
        double carValue = input.nextDouble();

        System.out.println("Enter the amount of installments(96 at most and 1 at least): ");
        double amountOfInstallments = input.nextDouble();


        if(capital >= 0 && capital <= 300000){
            double interest = 0;

            if(amountOfInstallments >= 1 && amountOfInstallments <= 24){
                interest = 0.02;

            }

            else if(amountOfInstallments >= 25 && amountOfInstallments <= 48){
                interest = 0.03;
            }

            else if(amountOfInstallments >= 49 && amountOfInstallments <= 60){
                interest = 0.04;
            }

            else if(amountOfInstallments >= 61 && amountOfInstallments <= 72){
                interest = 0.05;
            }

            else if(amountOfInstallments >= 73 && amountOfInstallments <= 96){
                interest = 0.06;
            }

            else{
                System.out.println("Invalid amount of interest value");
            }

            double monthlyPayment = (capital - carValue) * interest;
            System.out.printf("Monthly payment is equal to: %.2f", monthlyPayment);
        }

        else{
            System.out.println("Invalid capital value");
        }

        input.close();
    }
}
