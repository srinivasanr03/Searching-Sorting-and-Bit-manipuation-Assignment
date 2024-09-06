import java.util.Scanner;

public class Q2LastOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array
        System.out.print("Enter the elements of the array (space-separated): ");
        String input = scanner.nextLine();
        String[] arrStr = input.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        // Input the target integer
        System.out.print("Enter the target integer: ");
        int target = scanner.nextInt();
        scanner.close();

        // Find the last occurrence of the target integer
        int lastOccurrence = findLastOccurrence(arr, target);

        // Display the result
        System.out.println("Output: " + lastOccurrence);
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int lastOccurrence = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                lastOccurrence = i;
            }
        }
        return lastOccurrence;
    }
}
