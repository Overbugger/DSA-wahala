package com.endpoint.Search;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] array, int toBeFound) {
        int n = array.length;
        if (n < 2) {
            return 0;
        }

        sort(array);

        System.out.println(Arrays.toString(array));

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == toBeFound) {
                return mid;
            } else if (array[mid] > toBeFound) {
                right = mid - 1;
            } else if (array[mid] < toBeFound) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int optimalBinarySearch(int[] array, int toBeFound) {
        int n = array.length;
        if (n < 2) {
            return 0;
        }

        sort(array);

        int left = -1;
        int right = n;

        while (right > left + 1) {
            int mid = (left + right) / 2;
            if (array[mid] >= toBeFound) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(right == n) {
            return -1;
        }
        return right;
    }


    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;

            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        int[] testArr = {3, 5, 1, 7, 4, 5, 5, 9, 0, 2};
        System.out.println(optimalBinarySearch(testArr, 30));
    }
}