package com.endpoint.Sorting;

import com.endpoint.DS.Containers.Heap;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static <T extends Comparable<T>> List<T> heapSort(List<T> list) {

        if(list == null || list.size() <= 1) {
            assert list != null;
            return new ArrayList<>(list);
        }

        Heap<T> heap = new Heap<>(list);
        List<T> sortedArr = new ArrayList<>(list.size());
        while(!heap.getElements().isEmpty()) {
            sortedArr.addFirst(heap.top());
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(64, 34, 25, 12, 22, 11, 90);
        System.out.println("Original: " + numbers);
        System.out.println("Sorted (ascending): " + heapSort(numbers));
    }
}
