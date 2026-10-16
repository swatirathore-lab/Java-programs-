class Railway {
    private final boolean[] seats = new boolean[5];

    synchronized boolean book(int seat, String name) {
        if (!seats[seat]) {
            seats[seat] = true;
            System.out.println(name + " booked seat " + (seat + 1));
            return true;
        }
        System.out.println(name + " FAILED: seat " + (seat + 1) + " already taken");
        return false;
    }
}

public class RailwayReservation {
    public static void main(String[] args) throws InterruptedException {
        Railway railway = new Railway();
        Thread[] passengers = new Thread[8];
        for (int i = 0; i < passengers.length; i++) {
            final int seat = i % 5; // several passengers want the same seat
            passengers[i] = new Thread(() -> railway.book(seat, Thread.currentThread().getName()),
                    "Passenger-" + (i + 1));
            passengers[i].start();
        }
        for (Thread t : passengers) t.join();
    }
}