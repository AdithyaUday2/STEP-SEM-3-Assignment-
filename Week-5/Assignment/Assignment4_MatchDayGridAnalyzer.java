public class Assignment4_MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int runs : row) {
            sum = sum + runs;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0) {
                result = result + " | ";
            }

            if (average >= threshold) {
                result = result + "Match " + i + ": Power Surge";
            } else {
                result = result + "Match " + i + ": Normal";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runs, 8));
    }
}
