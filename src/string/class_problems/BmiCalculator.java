package string.class_problems;

/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Computes Body Mass Index (BMI) for a team of employees using their height and weight,
 * categorizes their health status (Underweight, Normal, Overweight, Obese),
 * and prints a formatted wellness report table.
 */
public class BmiCalculator {

    /**
     * Determines health status category based on BMI value.
     * 
     * @param bmi computed body mass index
     * @return health status string ("Underweight", "Normal", "Overweight", "Obese")
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes individual BMI given weight (kg) and height (m).
     * 
     * @param height height in meters
     * @param weight weight in kilograms
     * @return BMI value
     */
    public static double calculateBmi(double height, double weight) {
        if (height <= 0) return 0.0;
        return weight / (height * height);
    }

    /**
     * Generates and prints a comprehensive wellness report table for team data.
     * 
     * @param heights array of employee heights in meters
     * @param weights array of employee weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.err.println("Error: Invalid height/weight datasets.");
            return;
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s%n", 
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = calculateBmi(h, w);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-15s%n",
                    (i + 1), h, w, bmi, status);
        }

        System.out.println("----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("            Corporate Wellness Program: Team BMI Report");
        System.out.println("======================================================================");

        // Sample team data covering various categories including samples from requirements
        double[] heights = {1.75, 1.60, 1.80, 1.55, 1.68, 1.72, 1.90, 1.65, 1.78, 1.50};
        double[] weights = {70.0, 90.0, 60.0, 42.0, 75.0, 68.0, 110.0, 52.0, 82.0, 78.0};

        printWellnessReport(heights, weights);
        System.out.println("======================================================================");
    }
}
