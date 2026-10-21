
import java.util.Scanner;

public class Practice1_PaymentSystemFee {

    interface Payment {
        double calculate(double amount);
    }

    static class Card implements Payment {
        public double calculate(double amount) {
            return amount + amount * 0.02;
        }
    }

    static class Wallet implements Payment {
        public double calculate(double amount) {
            return amount + amount * 0.01;
        }
    }

    static class BankTransfer implements Payment {
        public double calculate(double amount) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new Card();
            } else if (type.equals("WALLET")) {
                payment = new Wallet();
            } else {
                payment = new BankTransfer();
            }

            double result = payment.calculate(amount);

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
