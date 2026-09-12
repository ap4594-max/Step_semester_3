package stringConcepts.assignment_problems;

/**
 * Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie-Review Moderation & Spam Profiling Tool
 * 
 * Splits incoming reviews into words and classifies each word by length into
 * Short (1-4 letters), Medium (5-8 letters), or Long (9+ letters) to flag anomalous reviews.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Classifies words in a review into Short, Medium, and Long categories and prints the summary.
     * 
     * @param review string containing review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip out surrounding punctuation for accurate word length analysis if present
            String cleanedWord = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            int len = cleanedWord.isEmpty() ? word.length() : cleanedWord.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    /**
     * Helper method to display review text and word classification breakdown.
     */
    public static void displayReviewProfiling(String review) {
        System.out.printf("Review : \"%s\"%n", review);
        System.out.print("Counts : ");
        classifyWordLengths(review);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        Movie Review Word Length Profiler         ");
        System.out.println("==================================================");

        // Test Case 1: Sample input from specification
        displayReviewProfiling("This movie was absolutely fantastic and thrilling");

        // Test Case 2: Short words only
        displayReviewProfiling("A fun cat dog film");

        // Test Case 3: Long words and complex descriptions
        displayReviewProfiling("Cinematography and orchestration were magnificent and breathtaking");

        // Test Case 4: Review with punctuation
        displayReviewProfiling("Great plot, exciting climax, but questionable acting.");

        System.out.println("==================================================");
    }
}
