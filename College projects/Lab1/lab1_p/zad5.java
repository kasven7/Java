package lab1_p;
import java.util.Scanner;


public class zad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the first number: ");
        double number1 = sc.nextDouble();

        System.out.println("Enter the second number: ");
        double number2 = sc.nextDouble();


        System.out.println("\"+\": addition");
        System.out.println("\"-\": subtraction");
        System.out.println("\"*\": multiplication");
        System.out.println("\"/\": division");
        System.out.println("Enter a symbol which represents a corresponding equation: ");
        char equationSymbol = sc.next().charAt(0);


        switch(equationSymbol){
            case '+':
                System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case '-':
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case '*':
                System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
                break;
            case '/':
                if(number2 == 0){
                    System.out.println("You can't divide by zero!");
                    System.exit(-1);

                }

                else{
                    System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
                }
                break;

            default:
                System.out.println("Invalid symbol");
                System.exit(-1);
        }

    }
}
