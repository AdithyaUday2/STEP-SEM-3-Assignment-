import java.util.Scanner;

public class Assignment4_LibraryISBNNormalizer {

    String normalizeCode(String raw) {
        raw = raw.trim();

        if (raw.length() < 3) {
            return raw.toUpperCase();
        }

        String first = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return first + rest;
    }

    String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(code.substring(3, 7));
        result.append(" | CATALOG: ");
        result.append(code.substring(7));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        Assignment4_LibraryISBNNormalizer obj =
                new Assignment4_LibraryISBNNormalizer();

        String normalized = obj.normalizeCode(raw);

        System.out.println(obj.validateAndFormat(normalized));
    }
}
