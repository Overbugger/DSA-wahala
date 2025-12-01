package com.endpoint.Sorting;

public class InsertionSort {

    private static void insertionSort(int[] arr) {

        var n = arr.length;

        for(int i = 0; i < n; i++) {

            var j = i;

            while(j > 0 && arr[j] < arr[j - 1]) {
                var temp = arr[j];

                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--;
            }

//            Shifting method
//            var key = arr[i];
//            var j = i - 1;
//
//            while(j >= 0 && arr[j] > key) {
//                arr[j+1] = arr[j];
//                j--;
//            }
//
//            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {9, 5, 1, 4, 3, 7, 2, 8, 6};

        System.out.println("Original Array:");
        printArray(data);

        insertionSort(data);

        System.out.println("\nSorted Array:");
        printArray(data);
    }


}
