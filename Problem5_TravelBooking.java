import java.util.Scanner;

public class Problem5_TravelBooking {

    static abstract class Booking {

        static final double BOOKING_FEE = 50.0;

        double distance;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double getFare();

        double getTotal() {
            return getFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {

        Bus(double distance) {
            super(distance);
        }

        double getFare() {
            return distance * 2;
        }
    }

    static class Train extends Booking {

        Train(double distance) {
            super(distance);
        }

        double getFare() {
            return distance * 1.5;
        }
    }

    static class Flight extends Booking {

        Flight(double distance) {
            super(distance);
        }

        double getFare() {
            return 2500 + (distance * 4);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } else {
                booking = new Flight(distance);
            }

            System.out.printf(
                "%s: %.2f%n",
                mode,
                booking.getTotal()
            );
        }

        sc.close();
    }
}
