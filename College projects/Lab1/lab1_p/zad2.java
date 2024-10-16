package lab2_p;
import java.lang.Math;
import java.util.Scanner;


public class zad2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("a = ");
        double a = input.nextDouble();

        System.out.print("b = ");
        double b = input.nextDouble();

        System.out.print("c = ");
        double c = input.nextDouble();


        double delta = Math.pow(b, 2) - (4 * a * c);
        System.out.println("Here is your square equation: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Δ = " + delta);


        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        if(delta > 0){
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.println("Here are the numbers that are the solution to your square equation:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

        }

        else if(delta == 0){
            System.out.println("Here is the solution to your square equation:");
            System.out.println("x = " + x1);

        }

        else if (delta < 0){
            System.out.println("Your square equation doesn't have a solution in real numbers!");
        }
        input.close();
    }
}
