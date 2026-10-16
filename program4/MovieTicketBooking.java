class Theatre {
    private int availableSeats = 10;

    synchronized void book(String user, int tickets) {
        if (tickets <= availableSeats) {
            availableSeats -= tickets;
            System.out.println(user + " booked " + tickets + " ticket(s). Seats left: " + availableSeats);
        } else {
            System.out.println(user + " FAILED to book " + tickets + ". Seats left: " + availableSeats);
        }
    }

    int getAvailableSeats() { return availableSeats; }
}

public class MovieTicketBooking {
    public static void main(String[] args) throws InterruptedException {
        Theatre theatre = new Theatre();
        Thread[] users = new Thread[7];
        for (int i = 0; i < users.length; i++) {
            final int tickets = (i % 3) + 1;
            users[i] = new Thread(() -> theatre.book(Thread.currentThread().getName(), tickets),
                    "User-" + (i + 1));
            users[i].start();
        }
        for (Thread t : users) t.join();
        System.out.println("Seats remaining: " + theatre.getAvailableSeats());
    }
}