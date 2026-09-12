package string.assignment_problems;

/**
 * Problem 4: The Warehouse Inventory Balancer
 * Scenario: Retail Storage Inventory Verification & Reconciliation
 * 
 * Verifies that two storage sections (Section A and Section B) contain equal total inventory,
 * checks balance status, and identifies the single highest-quantity item across both sections.
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across two sections, computes totals, evaluates balance status,
     * and identifies the highest quantity item location.
     * 
     * @param sectionA array of item quantities in Section A
     * @param sectionB array of item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid input: Inventory arrays cannot be null.");
            return;
        }

        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Section A and Section B must have the same number of categories.");
            return;
        }

        if (sectionA.length == 0) {
            System.out.println("Section A Total: 0 | Section B Total: 0 | Status: Balanced | Highest Quantity: None");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxItemIndex = 1;

        // Scan Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1; // 1-based item number
            }
        }

        // Scan Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1; // 1-based item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQty, maxSection, maxItemIndex);
    }

    /**
     * Helper method to format array into string for clean test output.
     */
    private static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Helper method to display inputs and analysis.
     */
    public static void displayInventoryAnalysis(int[] sectionA, int[] sectionB) {
        System.out.printf("Section A: %s%n", arrayToString(sectionA));
        System.out.printf("Section B: %s%n", arrayToString(sectionB));
        System.out.print("Analysis : ");
        analyzeInventory(sectionA, sectionB);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          Warehouse Inventory Balancer            ");
        System.out.println("==================================================");

        // Test Case 1: Sample from spec (Balanced, max in Section A)
        int[] a1 = {20, 15, 30};
        int[] b1 = {25, 10, 30};
        displayInventoryAnalysis(a1, b1);

        // Test Case 2: Unbalanced, max in Section B
        int[] a2 = {10, 20, 15};
        int[] b2 = {15, 45, 10};
        displayInventoryAnalysis(a2, b2);

        // Test Case 3: Multiple items, perfectly balanced
        int[] a3 = {50, 60, 70, 80};
        int[] b3 = {80, 70, 60, 50};
        displayInventoryAnalysis(a3, b3);

        System.out.println("==================================================");
    }
}
