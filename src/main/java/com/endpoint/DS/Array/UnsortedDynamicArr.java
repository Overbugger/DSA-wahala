package com.endpoint.DS.Array;

import java.util.Arrays;

public class UnsortedDynamicArr<T extends Comparable<T>> {
    private final Class<T> elementType;
    private Object[] array;
    private int capacity;
    private int size;

    public UnsortedDynamicArr(int initialCapacity, Class<T> elementType) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.array = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
        this.elementType = elementType;
    }

    /* -------------------- Utility Methods -------------------- */

    private void doubleCapacity() {
        Object[] oldArr = array;
        this.capacity *= 2;
        this.array = new Object[this.capacity];
        if (size >= 0) System.arraycopy(oldArr, 0, array, 0, size);
    }

    private void halfCapacity() {
        if (capacity <= 1) return; // Prevent reducing below 1
        Object[] oldArr = array;
        this.capacity /= 2;
        this.array = new Object[this.capacity];
        for (int i = 0; i < size && i < capacity; i++) {
            array[i] = oldArr[i];
        }
    }

    /* -------------------- Core Operations -------------------- */

    public void insert(T value) {
        if (size >= capacity) {
            doubleCapacity();
        }
        array[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        if (size < capacity / 4) {
            halfCapacity();
        }
    }

    public int getSize() {
        return size;
    }

    /* -------------------- Sorting -------------------- */
    public void mergeSort() {
        // Only sort the filled portion of the array
        Object[] filledArray = Arrays.copyOfRange(array, 0, size);
        Object[] sortedArray = mergeSort(filledArray);

        // Copy the sorted result back into the original array
        System.arraycopy(sortedArray, 0, array, 0, size);
    }

    private Object[] mergeSort(Object[] arr) {

        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        var leftArray = Arrays.copyOfRange(arr, 0, mid);
        var rightArray = Arrays.copyOfRange(arr, mid, arr.length);

        return merger(mergeSort(leftArray), mergeSort(rightArray));
    }

    private Object[] merger(Object[] leftArr, Object[] rightArr) {
        Object[] resultArr = new Object[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {

            T leftValue = (T) leftArr[leftIndex];
            T rightValue = (T) rightArr[rightIndex];

            if (leftValue.compareTo(rightValue) < 0) {
                resultArr[resultIndex++] = leftArr[leftIndex++];
            } else {
                resultArr[resultIndex++] = rightArr[rightIndex++];
            }
        }

        while (leftIndex < leftArr.length) {
            resultArr[resultIndex++] = leftArr[leftIndex++];
        }

        while (rightIndex < rightArr.length) {
            resultArr[resultIndex++] = rightArr[rightIndex++];
        }

        return resultArr;

    }


    /* -------------------- Debug / Display -------------------- */

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}