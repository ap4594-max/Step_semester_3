package string.class_problems;

/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Reverses a customer's name for verification/testing purposes without modifying
 * the original string data.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name and returns the reversed string.
     * 
     * @param customerName the original customer name
     * @return the reversed customer name, or null if input is null
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Helper method to display original and reversed customer names.
     */
    public static void displayReversedCustomer(String customerName) {
        String reversed = reverseCustomerName(customerName);
        System.out.printf("Original Name: %s%n", customerName);
        System.out.printf("Reversed Name: %s%n", reversed);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Customer Identity Verification: Reverse Name");
        System.out.println("==================================================");

        String[] customers = {"Sunil", "Alice Smith", "Rajesh", "Grace Hopper", "Bob"};

        for (String customer : customers) {
            displayReversedCustomer(customer);
        }

        System.out.println("==================================================");
    }
}
