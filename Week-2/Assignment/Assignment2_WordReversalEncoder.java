import java.util.Scanner;

public class Assignment2_WordReversalEncoder {

    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();

            result = result + sb;

            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        Assignment2_WordReversalEncoder obj =
                new Assignment2_WordReversalEncoder();

        System.out.println(obj.reverseEachWord(sentence));
    }
}
