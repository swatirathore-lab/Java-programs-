class ATM {
    private int balance = 5000;

    synchronized void withdraw(String user, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " withdrew " + amount + ". Balance: " + balance);
        } else {
            System.out.println(user + " DECLINED (" + amount + "). Balance: " + balance);
        }
    }

    int getBalance() { return balance; }
}

public class ATMWithdrawal {
    public static void main(String[] args) throws InterruptedException {
        ATM atm = new ATM();
        Thread[] users = new Thread[8];
        for (int i = 0; i < users.length; i++) {
            users[i] = new Thread(() -> atm.withdraw(Thread.currentThread().getName(), 1000),
                    "Transaction-" + (i + 1));
            users[i].start();
        }
        for (Thread t : users) t.join();
        System.out.println("Final balance: " + atm.getBalance());
    }
}