package com.endpoint.Sorting;

public class BitonicSort {

    // Compares and swaps elements based on direction
    // dir = 1 means ascending, dir = 0 means descending
    private static void compareAndSwap(int[] arr, int i, int j, int dir) {
        if ((arr[i] > arr[j] && dir == 1) || (arr[i] < arr[j] && dir == 0)) {
            // Swap elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Merges a bitonic sequence in ascending or descending order
    private static void bitonicMerge(int[] arr, int low, int count, int dir) {
        if (count > 1) {
            int k = count / 2;

            // Compare and swap elements that are k distance apart
            for (int i = low; i < low + k; i++) {
                compareAndSwap(arr, i, i + k, dir);
            }

            // Recursively merge both halves
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    // Creates a bitonic sequence and sorts it
    private static void bitonicSort(int[] arr, int low, int count, int dir) {
        if (count > 1) {
            int k = count / 2;

            // Sort first half in ascending order
            bitonicSort(arr, low, k, 1);

            // Sort second half in descending order
            bitonicSort(arr, low + k, k, 0);

            // Merge the whole sequence in the given direction
            bitonicMerge(arr, low, count, dir);
        }
    }

    // Main function to sort array
    public static void sort(int[] arr) {
        int n = arr.length;

        // Check if array size is power of 2
        if ((n & (n - 1)) != 0) {
            throw new IllegalArgumentException(
                    "Array size must be a power of 2. Size: " + n);
        }

        // Start sorting in ascending order (dir = 1)
        bitonicSort(arr, 0, n, 1);
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Test the implementation
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 8, 6, 2, 1, 5};

        System.out.println("Original array:");
        printArray(arr);

        sort(arr);

        System.out.println("Sorted array:");
        printArray(arr);

        // Test with another array
        int[] arr2 = {12, 45, 23, 51, 19, 8, 64, 31,
                27, 16, 55, 42, 38, 29, 10, 5};

        System.out.println("\nOriginal array 2:");
        printArray(arr2);

        sort(arr2);

        System.out.println("Sorted array 2:");
        printArray(arr2);
    }
}