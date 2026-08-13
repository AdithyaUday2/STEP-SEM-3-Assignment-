public class TrafficSignal {
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
    static void findLongestStreak(String signalLog) {
        int maxCount = 1;
        int currentCount = 1;
        char maxColor = signalLog.charAt(0);
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentCount = currentCount + 1;
            } else {
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxColor = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxCount + " times");
    }
}