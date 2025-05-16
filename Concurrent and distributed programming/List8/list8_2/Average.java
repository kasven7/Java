package List8.list8_2;

import java.util.List;

public class Average extends Thread{
    private List<Double> grades;


    public Average(List<Double> grades){
        this.grades = grades;
    }


    public void run(){
        System.out.println("Every instructor has given a grade. Counting the average...");


        synchronized (grades){
            double sum = 0.0;

            for(double grade : grades){
                sum += grade;
            }

            double avg = sum / grades.size();
            System.out.println("This is the average of grades of the student: " + avg);
        }
    }
}
