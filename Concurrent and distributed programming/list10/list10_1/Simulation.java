package list10.list10_1;

public class Simulation {
    public static void main(String[] args){
        ATM atm = new ATM();
        System.out.printf("Initial ATM balance: %d PLN%n", atm.calculateBalance());

        Bank bank = new Bank(atm);
        bank.start();

        int clientCount = 5;
        for (int i = 0; i < clientCount; i++) {
            Client client = new Client(atm, i + 1);
            client.start();
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulation finished");
        System.exit(0);
    }
}
