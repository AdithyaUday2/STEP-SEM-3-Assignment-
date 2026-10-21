
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice4_ExaminationGrader {

    static class Question {
        String correct, answer;
        double points;

        Question(String correct, String answer, double points) {
            this.correct = correct;
            this.answer = answer;
            this.points = points;
        }

        double grade() {
            return 0;
        }
    }

    static class MCQ extends Question {
        MCQ(String correct, String answer, double points) {
            super(correct, answer, points);
        }

        double grade() {
            if (correct.equalsIgnoreCase(answer))
                return points;
            return 0;
        }
    }

    static class TF extends Question {
        TF(String correct, String answer, double points) {
            super(correct, answer, points);
        }

        double grade() {
            if (correct.equalsIgnoreCase(answer))
                return points;
            return 0;
        }
    }

    static class Essay extends Question {
        Essay(String correct, String answer, double points) {
            super(correct, answer, points);
        }

        double grade() {
            String[] keywords = correct.split(",");
            int count = 0;

            for (String word : keywords) {
                if (answer.toLowerCase().contains(word.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2)
                return points * 0.75;
            else if (count == 1)
                return points * 0.50;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            ArrayList<String> data = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null)
                    data.add(matcher.group(1));
                else
                    data.add(matcher.group(2));
            }

            String type = data.get(0);
            String correct = data.get(2);
            String answer = data.get(3);
            double points = Double.parseDouble(data.get(4));

            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(correct, answer, points);
            } else if (type.equals("TF")) {
                q = new TF(correct, answer, points);
            } else {
                q = new Essay(correct, answer, points);
            }

            double score = q.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
