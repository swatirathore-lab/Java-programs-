class Addition extends Thread {
    int a, b;

    Addition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        System.out.println("Addition: " + (a + b));
    }
}

class Subtraction extends Thread {
    int a, b;

    Subtraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        System.out.println("Subtraction: " + (a - b));
    }
}

class Multiplication extends Thread {
    int a, b;

    Multiplication(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        System.out.println("Multiplication: " + (a * b));
    }
}

class Division extends Thread {
    int a, b;

    Division(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        if (b != 0) {
            System.out.println("Division: " + ((double) a / b));
        } else {
            System.out.println("Division by zero is not allowed");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        int a = 20, b = 5;

        Addition t1 = new Addition(a, b);
        Subtraction t2 = new Subtraction(a, b);
        Multiplication t3 = new Multiplication(a, b);
        Division t4 = new Division(a, b);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
