package lab2_p;
import java.util.Scanner;


public class zad3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the unit of measurement that you will be entering(either km/h or mph): ");
        String unitOfMeasure = input.nextLine();


        if(unitOfMeasure.equals("mph")){
            System.out.println("Enter the speed of your car in miles per hour: ");
            double speed = input.nextDouble();

            System.out.println("Here is the speed of your car in miles per hour: " + Math.round(speed) + "mph");
            System.out.println("Here is the speed of your car in kilometers per hour: " + Math.round((speed * 1.609344)) + "km/h");

        }

        else if(unitOfMeasure.equals("km/h")){
            System.out.println("Enter the speed of your car in kilometers per hour: ");
            double speed = input.nextDouble();

            System.out.println("Here is the speed of your car in kilometers per hour: " + Math.round(speed) + "km/h");
            System.out.println("Here is the speed of your car in miles per hour: " + Math.round(speed * 0.621371192 ) + "mph");

        }

        input.close();
    }
}
