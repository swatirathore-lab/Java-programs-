public class ExceptionPropagation {

    static void methodC() throws Exception {
        System.out.println("Inside methodC");
        throw new Exception("Something went wrong in methodC");
    }

    // methodB does not handle it, just passes it up
    static void methodB() throws Exception {
        System.out.println("Inside methodB");
        methodC();
        System.out.println("This line in methodB will not run");
    }

    // methodA finally handles it
    static void methodA() {
        System.out.println("Inside methodA");
        try {
            methodB();
        } catch (Exception e) {
            System.out.println("Exception handled in methodA: " + e.getMessage());
        }
        System.out.println("methodA continues after handling");
    }

    public static void main(String[] args) {
        methodA();
    }
}