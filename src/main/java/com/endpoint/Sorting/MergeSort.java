package com.endpoint.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    private static ArrayList<Integer> mergesort(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        int mid = arr.size() / 2;
        var leftArr = new ArrayList<Integer>(arr.subList(0, mid));
        var rightArr = new ArrayList<Integer>(arr.subList(mid, arr.size()));

        return merger(mergesort(leftArr), mergesort(rightArr));
    }

    private static ArrayList<Integer> merger(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        var resultArr = new ArrayList<Integer>(leftArr.size() + rightArr.size());
        var leftIndex = 0;
        var rightIndex = 0;
        var resultIndex = 0;

        while (leftIndex < leftArr.size() || rightIndex < rightArr.size()) {

            if (rightIndex == rightArr.size() || (leftIndex < leftArr.size() && (leftArr.get(leftIndex) < rightArr.get(rightIndex)))) {
                resultArr.add(resultIndex++, leftArr.get(leftIndex++));
            } else {
                resultArr.add(resultIndex++, rightArr.get(rightIndex++));

            }
        }

        return resultArr;
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> initialNumbers = Arrays.asList(9, 5, 1, 4, 3, 7, 2, 8, 6);
        ArrayList<Integer> data = new ArrayList<>(initialNumbers);

        System.out.println("Original Array:");
        printArray(data);

        System.out.println("\nSorted Array:");
        printArray(mergesort(data));
    }
}
