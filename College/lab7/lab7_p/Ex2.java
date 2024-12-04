package lab7_p;
import java.io.IOException;


public class Ex2{
    public static void main(String[] args){
        try{
            Calculator calc = new Calculator(14.5, 11, -200, 100, 12, 5, 1);
            Calculator calcFrFile = new Calculator(0);


            //csv file
            String filePath1 = "C:\\Users\\kkowa\\Downloads\\calc1.csv";
            calc.writeToFile(filePath1);
            calcFrFile.readFromFile(filePath1);


            // txt file
            String filePath2 = "C:\\Users\\kkowa\\Downloads\\calc1.txt";
            calc.writeToFile(filePath2);
            calcFrFile.readFromFile(filePath2);

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



