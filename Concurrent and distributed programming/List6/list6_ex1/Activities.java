package List6.list6_ex1;

import java.util.concurrent.Semaphore;

public class Activities {
    public static void main(String[] args){
        Semaphore sem = new Semaphore(1);
        Person mother = new Person("Mother", sem);
        Person father = new Person("Father", sem);
        Person child = new Person("Child", sem);

        mother.start();
        father.start();
        child.start();
    }
}
