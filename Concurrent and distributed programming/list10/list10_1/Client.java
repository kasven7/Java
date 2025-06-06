package list10.list10_1;
import java.util.*;


public class Client extends Thread{
    private final ATM atm;
    private final int clientId;

    public Client(ATM atm, int clientId) {
        this.atm = atm;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int amount = (random.nextInt(100) + 1) * 10;

                Map<Banknote, Integer> withdrawal = atm.withdraw(amount, clientId);

                if (withdrawal != null) {
                    System.out.printf("Client %d withdrew %d PLN: %s%n",
                            clientId, amount, formatWithdrawal(withdrawal));
                    Thread.sleep(random.nextInt(1500) + 500);
                } else {
                    System.out.printf("Client %d couldn't withdraw %d PLN (insufficient funds or ATM being refilled)%n",
                            clientId, amount);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String formatWithdrawal(Map<Banknote, Integer> withdrawal) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Banknote, Integer> entry : withdrawal.entrySet()) {
            if (!sb.isEmpty()) sb.append(", ");
            sb.append(entry.getValue()).append("x").append(entry.getKey().getValue());
        }
        return sb.toString();
    }
}
