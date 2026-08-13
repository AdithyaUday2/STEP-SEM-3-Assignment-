public class TypingAccuracyChecker {
    public static void main(String[] args) {
        String original = "hello world";
        String typed = "hello worlt";
        checkTypingAccuracy(original, typed);
    }
    static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matched = 0;
        int firstMismatchPosition = -1;
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched = matched + 1;
            } else {
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i;
                }
            }
        }
        double accuracy = ((double) matched / length) * 100;
        String accuracyText = String.format("%.2f", accuracy);
        if (firstMismatchPosition == -1) {
            System.out.println("Matched: " + matched + "/" + length + " | Accuracy: " + accuracyText + "% | No Mismatches");
        } else {
            char originalChar = original.charAt(firstMismatchPosition);
            char typedChar = typed.charAt(firstMismatchPosition);
            System.out.println("Matched: " + matched + "/" + length + " | Accuracy: " + accuracyText + "% | First Mismatch at position " + (firstMismatchPosition + 1) + " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }
}