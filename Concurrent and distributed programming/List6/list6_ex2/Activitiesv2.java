package List6.list6_ex2;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Activitiesv2 {
    public static void main(String[] args){
        final int numberOfPhones = 3;
        final int numberOfPeople = 10;
        Random random = new Random();
        Personv2[] people = new Personv2[numberOfPeople];
        Semaphore sem = new Semaphore(numberOfPhones);
        String[] names = {"Alice", "Oskar", "Bartek", "Bob", "Angela", "Dan", "Kacper", "Dariusz", "Piotr", "Steve"};


        for(int i = 0; i < numberOfPeople; i++){
            people[i] = new Personv2(getRandomName(names), sem);
            people[i].start();
        }
    }

    private static String getRandomName(String[] names){
        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }
}
