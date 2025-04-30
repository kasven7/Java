package List6.list6_ex3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Table {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Socrates", "Platon", "Aristotelis", "Democrat", "Protagoras");
        Collections.shuffle(names);

        final int NUM_PHILOSOPHERS = 5;
        Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        Semaphore queue = new Semaphore(NUM_PHILOSOPHERS - 1, true);

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];
            philosophers[i] = new Philosopher(i, names.get(i), leftFork, rightFork, queue);
            philosophers[i].start();
        }
    }
}