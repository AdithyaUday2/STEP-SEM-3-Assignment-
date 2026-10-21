
import java.util.Scanner;
import java.time.LocalDate;

public class Practice2_LibraryDueDate {

    static class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        int getDays() {
            return 0;
        }

        LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(getDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int getDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"", 2);

            String type = parts[0].trim();
            String title = parts[1].replace("\"", "").trim();

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
