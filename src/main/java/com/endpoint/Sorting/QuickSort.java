package com.endpoint.Sorting;

import java.util.*;

public class QuickSort {

    private List<Integer> list;

    public QuickSort(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public void sort() {
        quickSort(0, list.size());
    }

    public int find(int indexToBeFound) {
        return findByQuick(0, list.size(), indexToBeFound);
    }


    private int findByQuick(int leftBound, int rightBound, int indexToBeFound) {
        Random random = new Random();

        if(rightBound - leftBound < 2) {
            return list.get(leftBound);
        }

        int x = list.get(leftBound + random.nextInt(rightBound - leftBound));
        int mid = leftBound;

        for(int i = leftBound; i < rightBound; i++) {
            if(list.get(i) < x) {
                int temp = list.get(mid);
                list.set(mid, list.get(i));
                list.set(i, temp);
                mid++;
            }
        }

        if(indexToBeFound < mid) {
            return findByQuick(leftBound, mid, indexToBeFound);
        } else {
            return findByQuick(mid, rightBound, indexToBeFound);
        }
    }


    private void quickSort(int leftBound, int rightBound) {
        Random random = new Random();

        if(rightBound - leftBound < 2){
            return;
        }

        int x = list.get(leftBound + random.nextInt(rightBound - leftBound));

        int mid = leftBound;

        for(int i = leftBound; i < rightBound; i++) {
            var currentElement = list.get(i);
            if(currentElement < x) {
                int temp = list.get(mid);
                list.set(mid, currentElement);
                list.set(i, temp);
                mid++;
            }
        }

        quickSort(leftBound, mid);
        quickSort(mid, rightBound);
    }

//    Blum-Floyd-Pratt-Rivest-Taijan Algorithm for deterministic value of X
//    private int MedianOfMedian(int leftBound, int rightBound) {
//        int n = rightBound - leftBound;
//
//        if(n <= 5) {
//            return getMedian(leftBound, rightBound);
//        }
//
//        List<Integer> medians = new ArrayList<>();
//
//        for(int i = leftBound; i < rightBound; i += 5) {
//            int groupEnd = Math.min(i + 5, rightBound);
//            int median = getMedian(i, groupEnd);
//            medians.add(median);
//        }
//    }

    private int getMedian(int start, int end) {
        List<Integer> group = new ArrayList<>();
        for(int i = start; i < end; i++) {
            group.add(list.get(i));
        }
        Collections.sort(group);
        return group.get(group.size() / 2);
    }

    public static void main(String[] args) {

        List<Integer> testList = List.of(3,5,7,2,4,1);
        System.out.println(testList);
        QuickSort newQuickSort = new QuickSort(testList);
        newQuickSort.sort();
        System.out.println(newQuickSort.list);
        System.out.println(newQuickSort.find(4));
    }

}
