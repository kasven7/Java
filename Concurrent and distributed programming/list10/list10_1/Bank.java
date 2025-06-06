package list10.list10_1;


public class Bank extends Thread{
    private final ATM atm;

    public Bank(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // Check balance every second
                int balance = atm.calculateBalance();
                System.out.printf("ATM balance: %d PLN%n", balance);

                // Check if refill is needed
                if (balance < 3000) {
                    System.out.println("Bank: starting ATM refill");
                    atm.startRefill();
                    System.out.println("Bank: finished ATM refill");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
