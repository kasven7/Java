package lab7_p;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;


public class Calculator {
    private List<Double> numbers = new ArrayList<>();
    private double result;


    // 1-arg constructor
    public Calculator(double a){
        numbers.add(a);
    }

    // 4-arg constructor
    public Calculator(double a, double b, double c, double d){
        this(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);
    }

    // 7-arg constructor
    public Calculator(double a, double b, double c, double d, double e, double f, double g){
        this(a, b, c, d);
        numbers.add(e);
        numbers.add(f);
        numbers.add(g);

    }


    // copy constructor
    Calculator(Calculator calc){
        this.numbers = new ArrayList<>(calc.numbers);
        System.out.println("Here are the numbers used in an equation: " + this.numbers);

    }


    // methods
    double calculate(char equation){
        if (numbers.isEmpty()) {
            throw new IllegalStateException("No numbers to perform the calculation.");
        }


        switch(equation){
            case '+':
                for(double number : numbers)
                    result += number;
                break;

            case '-':
                for(double number : numbers)
                    result -= number;
                break;

            case '*':
                result = 1.0;

                for(double number : numbers)
                    result *= number;
                break;

            case '/':
                result = numbers.getFirst();

                for(int i = 1; i < numbers.size(); i++){
                    double number = numbers.get(i);

                    if(number == 0)
                        throw new ArithmeticException("Division by zero is not allowed!");
                    else
                        result /= number;
                }
                break;

            default:
                throw new IllegalArgumentException("Unsupported operation!");
        }

        return result;
    }


    // ex2 methods
    public void readFromFile(String filePath) throws IOException{
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            numbers = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(","))) // Split CSV format
                    .map(Double::parseDouble) // Parse to double
                    .collect(Collectors.toList());

        }
        System.out.println("Numbers read from file: " + numbers);
    }

    public void writeToFile(String filePath) throws IOException{
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            String data = numbers.stream()
                    .map(String::valueOf) // Convert each number to String
                    .collect(Collectors.joining(",")); // Join with commas
            writer.write(data);

        }
        System.out.println("Numbers written to file: " + filePath);
    }
}
