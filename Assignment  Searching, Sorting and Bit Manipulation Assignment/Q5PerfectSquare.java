import java.util.Scanner;

public class Q5PerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();
        scanner.close();

        boolean result = isPerfectSquare(num);
        System.out.println("Output: " + result);
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 0)
            return false;

        // Binary search approach to find if num is a perfect square
        long left = 0;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num)
                return true;
            else if (square < num)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
