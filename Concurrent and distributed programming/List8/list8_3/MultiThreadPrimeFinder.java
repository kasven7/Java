package List8.list8_3;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadPrimeFinder extends Thread{
    private List<Integer> primes = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private final int startPos;
    private final int endPos;


    public MultiThreadPrimeFinder(List<Integer> numbers, final int startPos, final int endPos){
        this.numbers = numbers;
        this.startPos = startPos;
        this.endPos = endPos;
    }


    private boolean isPrime(int n){
        if(n <= 1)
            return false;

        else{
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0)
                    return false;
            }
        }

        return true;
    }


    public void printPrimes(){
        int count = 0;

        System.out.print("{");
        for(Integer prime : primes){
            System.out.print(prime);
            count++;

            if(count != primes.size()){
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
    }

    public List<Integer> getPrimes() {
        return primes;
    }


    public void run(){
        for(int i = startPos; i < endPos; i++){
            if(isPrime(numbers.get(i)))
                primes.add(numbers.get(i));
        }
    }
}
