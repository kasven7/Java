package list10.list10_1;

public class Simulation {
    public static void main(String[] args){
        ATM atm = new ATM();
        System.out.printf("Initial ATM balance: %d PLN%n", atm.calculateBalance());

        // Start bank thread
        Bank bank = new Bank(atm);
        bank.start();

        // Start client threads
        int clientCount = 5;
        for (int i = 0; i < clientCount; i++) {
            Client client = new Client(atm, i + 1);
            client.start();
        }

        // Let the simulation run for 30 seconds
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulation finished");
        System.exit(0);
    }
}
