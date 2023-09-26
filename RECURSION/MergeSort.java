import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("Enter the size of the array:"); // Prompt the user to enter the size of the array
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // Read the size of the array from the user
        int[] arr = new int[size]; // Create an array of the specified size
        System.out.println("Enter the array elements:");

        // Read the array elements from the user
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        mergesort(arr, 0, arr.length); // Call the mergesort function to sort the array
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr)); // Print the sorted array
    }

    static void mergesort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return; // If the array has only one element, it is already sorted, so return
        }
        int mid = (s + e) / 2; // Calculate the middle index of the array
        mergesort(arr, s, mid); // Recursively sort the left half of the array
        mergesort(arr, mid, e); // Recursively sort the right half of the array
        merge(arr, s, mid, e); // Merge the two sorted halves
    }

    static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s]; // Create a temporary array to hold the merged elements
        int i = s; // Initialize a pointer for the left subarray
        int j = m; // Initialize a pointer for the right subarray
        int k = 0; // Initialize a pointer for the merged array

        // Merge the elements from the left and right subarrays
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (i < m) {
            mix[k++] = arr[i++];
        }

        // Copy any remaining elements from the right subarray
        while (j < e) {
            mix[k++] = arr[j++];
        }

        // Copy the merged elements back to the original array
        for (int ind = 0; ind < mix.length; ind++) {
            arr[s + ind] = mix[ind];
        }
    }
}
