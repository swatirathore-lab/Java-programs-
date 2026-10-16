class Wallet {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " FAILED to withdraw " + amount
                    + ". Balance: " + balance);
        }
    }

    int getBalance() { return balance; }
}

public class DigitalWallet {
    public static void main(String[] args) throws InterruptedException {
        Wallet wallet = new Wallet();
        Thread[] threads = new Thread[6];
        for (int i = 0; i < threads.length; i++) {
            final boolean isDeposit = (i % 2 == 0);
            threads[i] = new Thread(() -> {
                if (isDeposit) wallet.deposit(500);
                else wallet.withdraw(300);
            }, (isDeposit ? "Deposit-" : "Withdraw-") + (i + 1));
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        // 1000 + 3*500 - 3*300 = 1600
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
