package string.class_problems;

/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Verifies if a given string is a palindrome using three independent techniques:
 * 1. Iterative two-pointer approach
 * 2. Recursive substring comparison
 * 3. Character array reversal
 * 
 * Ensures all three approaches produce consistent results across test cases.
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check using two pointers moving towards the middle.
     * 
     * @param text input string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check comparing first and last characters, shrinking the substring.
     * 
     * @param text input string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Character array reversal and comparison with the original string.
     * 
     * @param text input string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedString = new String(reversed);
        return text.equals(reversedString);
    }

    /**
     * Helper to format palindrome boolean outcome into display text.
     */
    private static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    /**
     * Verifies and prints the results across all three approaches for a given input.
     */
    public static void verifyText(String text) {
        boolean iterativeRes = isPalindromeIterative(text);
        boolean recursiveRes = isPalindromeRecursive(text);
        boolean arrayRes = isPalindromeArrayReversal(text);

        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                text,
                formatResult(iterativeRes),
                formatResult(recursiveRes),
                formatResult(arrayRes));

        // Sanity check to confirm all three agree
        if (iterativeRes == recursiveRes && recursiveRes == arrayRes) {
            // Consistent
        } else {
            System.err.println("Warning: Inconsistency detected between approaches!");
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          QA Text Verification: Palindrome Checker");
        System.out.println("==================================================");

        String[] testCases = {"madam", "hello", "racecar", "step on no pets", "java"};

        for (String test : testCases) {
            verifyText(test);
        }

        System.out.println("==================================================");
    }
}
