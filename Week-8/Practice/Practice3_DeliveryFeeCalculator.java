
import java.util.Scanner;

public class Practice3_DeliveryFeeCalculator {

    interface Delivery {
        double calculateFee();
    }

    static class Standard implements Delivery {
        double weight, distance;

        Standard(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express implements Delivery {
        double weight, distance;

        Express(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class International implements Delivery {
        double weight, distance, customsFee;

        International(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public double calculateFee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new Standard(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new Express(weight, distance);
            } else {
                double customsFee = sc.nextDouble();
                delivery = new International(weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
