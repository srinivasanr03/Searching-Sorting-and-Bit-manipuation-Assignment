import java.util.Scanner;

public class Q4CountOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array
        System.out.print("Enter the elements of the array (sorted, space-separated): ");
        String input = scanner.nextLine();
        String[] arrStr = input.split(" ");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }

        // Input the target number
        System.out.print("Enter the target number: ");
        int target = scanner.nextInt();
        scanner.close();

        // Count the occurrences of the target number
        int count = countOccurrences(nums, target);

        // Display the result
        if (count == 0) {
            System.out.println("Target " + target + " is not found in the array.");
        } else {
            System.out.println("Target " + target + " occurs " + count + " times");
        }
    }

    public static int countOccurrences(int[] nums, int target) {
        int firstOccurrence = findFirstOccurrence(nums, target);
        if (firstOccurrence == -1) {
            return 0; // If the target number is not found, return 0 occurrences
        }
        
        int lastOccurrence = findLastOccurrence(nums, target);
        
        return lastOccurrence - firstOccurrence + 1; // Count occurrences between first and last occurrence
    }

    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                return mid; // Found first occurrence
            } else if (nums[mid] >= target) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }
        return -1; // Target number not found
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                return mid; // Found last occurrence
            } else if (nums[mid] <= target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target number not found
    }
}
