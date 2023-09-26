import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Enter the size of the array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");

        // Read the array elements from the user
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        quicksort(arr, 0, arr.length - 1); // Call the quicksort function to sort the array
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr)); // Print the sorted array
    }

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotind = partition(arr, low, high); // Find the pivot index
            quicksort(arr, low, pivotind - 1); // Recursively sort the left subarray
            quicksort(arr, pivotind + 1, high); // Recursively sort the right subarray
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose the pivot element as the first element
        int i = low + 1;
        int j = high;

        while (true) {
            // Find an element on the left side that is greater than the pivot
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            // Find an element on the right side that is less than the pivot
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                // Swap arr[i] and arr[j] if they are out of place
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                // Swap arr[low] (pivot) and arr[j] to place the pivot in its correct position
                int temp = arr[low];
                arr[low] = arr[j];
                arr[j] = temp;
                return j; // Return the pivot index
            }
        }
    }
}
