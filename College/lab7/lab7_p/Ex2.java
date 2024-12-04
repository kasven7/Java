package lab7_p;


import java.io.IOException;

public class Ex2{
    public static void main(String[] args){
        try{
            Calculator calc = new Calculator(14.5, 11, -200, 100, 12, 5, 1);
            Calculator calcFrFile = new Calculator(0);


            String filePath = "calc.txt";
            calc.writeToFile(filePath);
            calcFrFile.readFromFile(filePath);


            System.out.println("Calculation: " + calcFrFile.calculate('*'));

        } catch(IOException io){
            System.err.println("Error with writing content to a file: " + io.getMessage());
            io.printStackTrace();
        }

        catch(Exception e){
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}



