class Inventory {
    private int stock = 10;

    synchronized void purchase(String customer, int qty) {
        if (stock >= qty) {
            stock -= qty;
            System.out.println(customer + " bought " + qty + ". Stock left: " + stock);
        } else {
            System.out.println(customer + " could not buy " + qty + ". Only " + stock + " left");
        }
    }

    int getStock() { return stock; }
}

public class OnlineShopping {
    public static void main(String[] args) throws InterruptedException {
        Inventory inv = new Inventory();
        Thread[] customers = new Thread[8];
        for (int i = 0; i < customers.length; i++) {
            final int qty = (i % 3) + 1;
            customers[i] = new Thread(() -> inv.purchase(Thread.currentThread().getName(), qty),
                    "Customer-" + (i + 1));
            customers[i].start();
        }
        for (Thread t : customers) t.join();
        System.out.println("Final stock: " + inv.getStock());
    }
}