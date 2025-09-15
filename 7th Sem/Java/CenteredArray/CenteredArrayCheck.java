package CenteredArray;

public class CenteredArrayCheck {

    public static int isCentered(int[] arr) {
        // Check for null or even-length arrays
        if (arr == null || arr.length % 2 == 0) {
            return 0;
        }

        int midIndex = arr.length / 2;
        int midValue = arr[midIndex];

        for (int i = 0; i < arr.length; i++) {
            if (i != midIndex && arr[i] <= midValue) {
                return 0; // Found an element not strictly greater
            }
        }
        return 1; // All conditions satisfied
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 4, 5}; // Middle element = 1
        int[] arr2 = {3, 2, 3, 4};    // Even length (should return 0)
        int[] arr3 = {5, 10, 3, 10, 12}; // Middle = 3, others > 3 → return 1

        System.out.println(isCentered(arr1)); // 1
        System.out.println(isCentered(arr2)); // 0
        System.out.println(isCentered(arr3)); // 1
    }
}
