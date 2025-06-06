package list10.list10_1;
import java.util.*;
import java.util.concurrent.locks.*;


enum Banknote {
    TEN(10), TWENTY(20), FIFTY(50),
    ONE_HUNDRED(100), TWO_HUNDRED(200), FIVE_HUNDRED(500);

    private final int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


public class ATM {
    private final Map<Banknote, Integer> banknotes = new EnumMap<>(Banknote.class);
    private final Lock lock = new ReentrantLock();
    private final Condition refillCondition = lock.newCondition();
    private final Condition customerCondition = lock.newCondition();
    private boolean refillInProgress = false;
    private Integer currentCustomer = null;

    public ATM() {
        // Initialize with 20 of each banknote
        for (Banknote note : Banknote.values()) {
            banknotes.put(note, 20);
        }
    }

    public int calculateBalance() {
        return banknotes.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getValue() * entry.getValue())
                .sum();
    }

    public Map<Banknote, Integer> withdraw(int amount, int customerId) throws InterruptedException {
        lock.lock();
        try {
            // Wait if ATM is being refilled or another customer is withdrawing
            while (refillInProgress || (currentCustomer != null && currentCustomer != customerId)) {
                if (currentCustomer != null && currentCustomer == customerId) {
                    break; // Current customer can continue
                }
                customerCondition.await();
            }

            currentCustomer = customerId;

            if (refillInProgress) {
                return null; // ATM is being refilled
            }

            // Check if we have enough funds
            if (amount > calculateBalance()) {
                currentCustomer = null;
                customerCondition.signalAll();
                return null;
            }

            // Try to withdraw the amount
            Map<Banknote, Integer> withdrawal = new EnumMap<>(Banknote.class);
            int remaining = amount;

            List<Banknote> sortedNotes = new ArrayList<>(Arrays.asList(Banknote.values()));
            sortedNotes.sort(Comparator.comparingInt(Banknote::getValue).reversed());

            for (Banknote note : sortedNotes) {
                if (remaining <= 0) break;
                int available = banknotes.get(note);
                if (available > 0) {
                    int count = Math.min(remaining / note.getValue(), available);
                    if (count > 0) {
                        withdrawal.put(note, count);
                        remaining -= note.getValue() * count;
                    }
                }
            }

            if (remaining == 0) {
                // Confirm withdrawal
                withdrawal.forEach((note, count) -> banknotes.put(note, banknotes.get(note) - count));
                currentCustomer = null;
                customerCondition.signalAll();
                return withdrawal;
            } else {
                // Cannot withdraw exact amount
                currentCustomer = null;
                customerCondition.signalAll();
                return null;
            }
        } finally {
            lock.unlock();
        }
    }

    public void startRefill() throws InterruptedException {
        lock.lock();
        try {
            refillInProgress = true;

            // Wait for current customer to finish
            while (currentCustomer != null) {
                refillCondition.await();
            }

            // Refill ATM
            for (Banknote note : Banknote.values()) {
                banknotes.put(note, 20);
            }

            refillInProgress = false;
            customerCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
