package stringConcepts.assignment_problems;


/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: The Examination Cell Seat Allocation Verification
 * 
 * Scans an array of assigned seat numbers to detect and flag any duplicated seat assignments
 * before the exam begins. Uses only arrays and nested loops (no Collections class).
 */
public class ExamSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers in the assigned seat array using nested loops.
     * 
     * @param seatNumbers array of integer seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Seat Numbers Provided");
            return;
        }

        boolean foundDuplicate = false;
        boolean[] isReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (isReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    isReported[j] = true; // Mark subsequent occurrences as reported
                }
            }

            if (isCurrentDuplicate) {
                foundDuplicate = true;
                System.out.printf("Duplicate Seat Number Found: %d%n", seatNumbers[i]);
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    /**
     * Helper method to display inputs and run the duplication check.
     */
    public static void displaySeatCheck(int[] seats) {
        System.out.print("Input Seats: ");
        if (seats == null) {
            System.out.println("null");
        } else {
            System.out.print("{");
            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i]);
                if (i < seats.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
        System.out.print("Output: ");
        checkDuplicateSeats(seats);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    Exam Hall Seat Duplication Checker (Arrays)   ");
        System.out.println("==================================================");

        // Test Case 1: Sample with duplicates
        int[] hall1 = {101, 102, 103, 102, 105};
        displaySeatCheck(hall1);

        // Test Case 2: Sample without duplicates
        int[] hall2 = {101, 102, 103, 104, 105};
        displaySeatCheck(hall2);

        // Test Case 3: Multiple different duplicates
        int[] hall3 = {201, 202, 203, 201, 204, 203, 205};
        displaySeatCheck(hall3);

        // Test Case 4: Single seat assignment
        int[] hall4 = {301};
        displaySeatCheck(hall4);

        System.out.println("==================================================");
    }
}
