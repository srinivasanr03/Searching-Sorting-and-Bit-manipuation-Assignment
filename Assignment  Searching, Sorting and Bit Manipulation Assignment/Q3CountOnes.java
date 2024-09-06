import java.util.Scanner;

public class Q3CountOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array
        System.out.print("Enter the elements of the array (sorted binary, space-separated): ");
        String input = scanner.nextLine();
        String[] arrStr = input.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        scanner.close();

        // Count the number of ones in the array
        int count = countOnes(arr);

        // Display the result
        System.out.println("Output: " + count);
    }

    public static int countOnes(int[] arr) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        // Binary search for the first occurrence of 1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 1) {
                count = arr.length - mid;
                right = mid - 1; // Continue searching in the left half
            } else {
                left = mid + 1; // Continue searching in the right half
            }
        }

        return count;
    }
}
