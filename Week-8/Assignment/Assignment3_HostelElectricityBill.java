
import java.util.Scanner;

public class Assignment3_HostelElectricityBill {

    interface Room {
        double calculateBill();
    }

    static class Single implements Room {
        int units;

        Single(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 8;
        }
    }

    static class Shared implements Room {
        int units, occupants;

        Shared(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class AC implements Room {
        int units;

        AC(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SINGLE")) {
                room = new Single(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new Shared(units, occupants);
            } else {
                room = new AC(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
