
import java.util.Scanner;
import java.time.LocalDate;

public class Assignment5_StreamingRenewalReminder {

    interface Plan {
        LocalDate getRenewalDate();
    }

    static class Basic implements Plan {
        String name;
        LocalDate startDate;

        Basic(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public LocalDate getRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    static class Standard implements Plan {
        String name;
        LocalDate startDate;

        Standard(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public LocalDate getRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    static class Premium implements Plan {
        String name;
        LocalDate startDate;

        Premium(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public LocalDate getRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC"))
                plan = new Basic(name, startDate);
            else if (type.equals("STANDARD"))
                plan = new Standard(name, startDate);
            else
                plan = new Premium(name, startDate);

            System.out.println(name + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}
