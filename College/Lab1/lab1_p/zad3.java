package lab1_p;
import java.util.Scanner;


class zad3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the speed of your car in miles per hour: ");
        double speed = sc.nextDouble();

        System.out.println("Here is the speed of your car in miles per hour: " + speed + "mph");
        System.out.println("Here is the speed of your car in kilometers per hour: " + (speed * 1.61) + "km/h");

    }
}