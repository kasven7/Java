package List8.list8_2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Instructor extends Thread{
    private CyclicBarrier barrier;
    private List<Double> grades;


    public Instructor(String name, CyclicBarrier barrier, List<Double> grades){
        super(name);
        this.barrier = barrier;
        this.grades = grades;
    }


    public void run(){
        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(2000) + 2000);

            double grade = 2.0 + random.nextDouble(3) ;
            grade = Math.round(grade);

            synchronized (grades){
                grades.add(grade);
                System.out.println(Thread.currentThread().getName() + " has given a rating: " + grade);
            }

            barrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
