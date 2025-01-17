package lab11_p;
import java.util.Scanner;


public class Zad1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        try{
            System.out.println("WELCOME TWO NUMBER DIVISION PROGRAM!\n\n");
            System.out.print("Enter x's value: ");
            double x = in.nextDouble();

            System.out.print("Enter y's value: ");
            double y = in.nextDouble();

            if(y == 0.0){
                throw new ArithmeticException();
            }
            else{
                System.out.println("Result: " + x + " : " + y + " = " + (x / y));
            }
        } catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("You can't divide by zero!");
        }

        finally {
            in.close();
        }
    }
}
