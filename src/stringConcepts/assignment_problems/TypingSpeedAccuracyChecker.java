package stringConcepts.assignment_problems;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 * Scenario: Online Typing-Practice Accuracy Verification
 * 
 * Compares a user's typed passage against the original reference text character by character,
 * computing match counts, accuracy percentage, and identifying the 1-based position of the first error.
 */
public class TypingSpeedAccuracyChecker {

    /**
     * Compares original and typed strings and prints accuracy metrics and mismatch location.
     * 
     * @param original the original reference passage
     * @param typed the user's typed text
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Original and typed strings must not be null.");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Error: Original and typed strings must be of equal length.");
            return;
        }

        int totalChars = original.length();
        if (totalChars == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = '\0';
        char typedMismatchChar = '\0';

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index position
                origMismatchChar = origChar;
                typedMismatchChar = typedChar;
            }
        }

        double accuracy = ((double) matchedCount / totalChars) * 100.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedCount, totalChars, accuracy));

        if (firstMismatchPos == -1) {
            sb.append("No Mismatches");
        } else {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, origMismatchChar, typedMismatchChar));
        }

        System.out.println(sb.toString());
    }

    /**
     * Helper method to display inputs and run the accuracy checker.
     */
    public static void displayTypingTest(String original, String typed) {
        System.out.printf("Original : \"%s\"%n", original);
        System.out.printf("Typed    : \"%s\"%n", typed);
        System.out.print("Result   : ");
        checkTypingAccuracy(original, typed);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    Typing Speed Test Accuracy Checker            ");
        System.out.println("==================================================");

        // Test Case 1: Sample input with mismatch
        displayTypingTest("hello world", "hello worlt");

        // Test Case 2: Sample input perfect match
        displayTypingTest("coding", "coding");

        // Test Case 3: Early mismatch
        displayTypingTest("Structure", "Strxcture");

        // Test Case 4: Complete mismatch
        displayTypingTest("ABCD", "WXYZ");

        System.out.println("==================================================");
    }
}
