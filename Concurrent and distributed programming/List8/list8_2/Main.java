package List8.list8_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args){
        final int INSTRUCTORS = 4;
        List<Double> grades = Collections.synchronizedList(new ArrayList<>());
        CyclicBarrier barrier = new CyclicBarrier(INSTRUCTORS, new Average(grades));


        for(int i = 0; i < INSTRUCTORS; i++){
            new Instructor("Instructor: " + i, barrier, grades).start();
        }
    }
}
