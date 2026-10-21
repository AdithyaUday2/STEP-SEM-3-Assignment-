
import java.util.Scanner;

public class Practice5_TransportFareCalculator {

    interface Transport {
        double calculateFare();
    }

    static class Bus implements Transport {
        double distance;

        Bus(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            double fare = 2 + 0.10 * distance;

            if (fare > 10)
                fare = 10;

            return fare;
        }
    }

    static class Train implements Transport {
        double distance;

        Train(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro implements Transport {
        double distance, factor;

        Metro(double distance, double factor) {
            this.distance = distance;
            this.factor = factor;
        }

        public double calculateFare() {
            return (1.50 + 0.20 * distance) * factor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
