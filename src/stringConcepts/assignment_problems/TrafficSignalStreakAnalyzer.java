package stringConcepts.assignment_problems;

/**
 * Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City Traffic Control Signal Malfunction Detection
 * 
 * Analyzes logs of traffic signal readings ('R', 'Y', 'G') to find and report
 * the longest continuous streak of any single color.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of identical consecutive characters
     * in the given signal log.
     * 
     * @param signalLog string containing signal color readings (e.g., "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal readings provided.");
            return;
        }

        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = c;
                currentStreak = 1;
            }
        }

        // Final streak check at end of string
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        System.out.printf("Longest Streak: '%c' repeated %d %s%n",
                maxChar, maxStreak, (maxStreak == 1 ? "time" : "times"));
    }

    /**
     * Helper method to display test input and its longest streak result.
     */
    public static void displaySignalLogAnalysis(String signalLog) {
        System.out.printf("Signal Log : \"%s\"%n", signalLog);
        System.out.print("Result     : ");
        findLongestStreak(signalLog);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        Traffic Signal Streak Analyzer            ");
        System.out.println("==================================================");

        // Test Case 1: Sample input from spec
        displaySignalLogAnalysis("RRGGGYRR");

        // Test Case 2: Sample input from spec
        displaySignalLogAnalysis("RRRRYYGG");

        // Test Case 3: Alternating readings (streak = 1)
        displaySignalLogAnalysis("RYGRYG");

        // Test Case 4: Single color throughout
        displaySignalLogAnalysis("GGGGGG");

        // Test Case 5: Streak at the end
        displaySignalLogAnalysis("RRGYYYYY");

        System.out.println("==================================================");
    }
}
