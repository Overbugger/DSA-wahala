package com.endpoint.DS.Array;

public class SortedArr {
    private final int[] array;
    private int size;
    private final int maxSize;

    public SortedArr(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
        this.size = 0;
    }

//    public void insert(int value) {
//        if (size >= maxSize) {
//            throw new IllegalStateException("Array is full");
//        }
//
//        for (int i = size; i > 0; i--) {
//            if (array[i - 1] <= value) {
//                array[i] = value;
//                size++;
//                return;
//            } else {
//                array[i] = array[i - 1];
//            }
//        }
//
//        array[0] = value;
//        size++;
//    }

    public void insert(int value) {
        if (size >= maxSize) {
        throw new IllegalStateException("Array is full");
        }

        int i;
        for(i = size - 1; i >= 0 && array[i] > value; i--) {
            array[i + 1] = array[i];
        }

        array[i + 1] = value;
        size++;
    }

    public void deleteByIndex(int indexToDelete) {
        if(indexToDelete < 0 || indexToDelete >= size) {
            throw new IndexOutOfBoundsException("index to be deleted doesn't exist");
        }

        for(int i = indexToDelete; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = 0;
        size --;
    }

    public void deleteByValue(int value) {
        deleteByIndex(binarySearch(value));
    }

    public int linearSearch(int value) {
        for(int i = 0; i < size; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        throw new IllegalArgumentException("Value " + value + " not found in the array");
    }

    public int binarySearch(int value) {
        int left = 0;
        int right = size - 1;
         while(left <= right) {
             int mid = left + (right -left) / 2;
             if(array[mid] == value){
                 return mid;
             }else if(array[mid] > value) {
                 right = mid - 1;
             }else if(array[mid] < value) {
                 left = mid + 1;
             }
         }
         return -1;
    }

    private int recursiveBinarySearch(int start, int end, int value) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if(array[mid] == value){
            return mid;
        }else if(array[mid] > value) {
           return recursiveBinarySearch(start, mid - 1, value);
        }else {
            return recursiveBinarySearch(mid + 1, end, value);
        }
    }

    public int recursiveBinarySearch(int value) {
        return recursiveBinarySearch(0, size - 1, value);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
