package com.endpoint.Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = arr[0];
        int min =  arr[0];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int range = max - min + 1;

        // Create count array
        int[] count = new int[range];

        // Count occurrences of each element
        for(int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        System.out.println(Arrays.toString(count));

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int value = i + min;  // The actual value
            int occurrences = count[i];  //     How many times it appears

            // Write this value 'occurrences' times
            while (occurrences > 0) {
                arr[index++] = value;
                occurrences--;
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 2, 3};
        countingSort(arr);
    }

}
