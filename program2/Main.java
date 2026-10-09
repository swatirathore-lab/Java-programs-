class MyRunnable implements Runnable {

    public void run() {
        System.out.println("Thread is running using Runnable");
    }
}

public class Main {
    public static void main(String[] args) {

        MyRunnable obj = new MyRunnable();

        Thread t = new Thread(obj);

        t.start();
    }
}