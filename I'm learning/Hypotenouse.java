import java.util.Scanner;

class Hypotenouse {

    static boolean isTriangleRight(double x, double y){
        double z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return (z*z) == (x * x + y * y);
    }

    public static void main(String[] args){
        double x;
        double y;
        double z;
        Scanner side = new Scanner(System.in);

        System.out.print("Enter the side x(in centimeters): ");
        x = side.nextDouble();

        System.out.print("Enter the side y(in centimeters): ");
        y = side.nextDouble();


        if(isTriangleRight(x, y)){
            System.out.println("\nYour triangle is right angled!");
            System.out.println("Calculating your hypotenouse...");

            z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            System.out.println("Its hypotenouse is equal to " + z + "cm");
        }

        else{
            System.out.println("\nYour triangle is not right angled!");
            System.out.println("The hypotenouse cannot be calculated!");
        }
    }
}