package string.class_problems;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Computes frequency of every character in an input string and scans left-to-right
 * to identify the first character with a frequency of exactly 1.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in the given text.
     * 
     * @param text input string
     * @return the first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Count frequencies of all ASCII characters
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequency[ch]++;
            }
        }

        // Scan from left to right to find the first unique character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    /**
     * Helper to process and display the result formatted according to the specification.
     */
    public static void displayFirstUnique(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\"%n", text);
        if (result != '\0') {
            System.out.printf("Output: First Non-Repeating Character: '%c'%n", result);
        } else {
            System.out.println("Output: No Non-Repeating Character Found");
        }
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       Unique Letter Hunt: First Non-Repeating Char");
        System.out.println("==================================================");

        String[] testCases = {"swiss", "aabbcc", "algorithms", "stress", "teeter"};

        for (String test : testCases) {
            displayFirstUnique(test);
        }

        System.out.println("==================================================");
    }
}
