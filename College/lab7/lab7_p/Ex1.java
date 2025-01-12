package lab7_p;


public class Ex1 {
    public static void main(String[] args){
        Calculator calc = new Calculator(14.2, 11, -23, 500, 12.2, -8, 1000);
        Calculator calc1 = new Calculator(calc);
        double result = calc1.calculate('+');

        System.out.println("The result of your equation is: " + result);
    }
}
