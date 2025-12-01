package com.endpoint.DS.Containers;

import com.endpoint.DS.LinkedList.Node;
import com.endpoint.DS.LinkedList.SinglyLinkedList;

import java.math.BigDecimal;
import java.util.function.Function;

public class HashTable <T extends Comparable<T>> {
    private static final BigDecimal A = new BigDecimal(
            (Math.sqrt(5) - 1) / 2
    );
    private int m;
    private SinglyLinkedList<T>[] data;
    private Function<Object, Integer> extractKey;

    public HashTable(int buckets, Function<Object, Integer> extractKey) {
        this.m = buckets;
        @SuppressWarnings("unchecked")
        SinglyLinkedList<T>[] tempData = (SinglyLinkedList<T>[]) new SinglyLinkedList[buckets];
        this.data = tempData;

        for (int i = 0; i < buckets; i++) {
            this.data[i] = new SinglyLinkedList();
        }

        this.extractKey = extractKey;
    }

    public HashTable(int buckets) {
        this(buckets, Object::hashCode);
    }

    private int hash(int key) {
        // Convert key to BigDecimal for precision
        BigDecimal keyDecimal = new BigDecimal(key);

        // Multiply key by A (golden ratio constant)
        BigDecimal product = keyDecimal.multiply(A);

        // Get fractional part: (key * A) % 1
        BigDecimal fractionalPart = product.remainder(BigDecimal.ONE);

        // Multiply by m (number of buckets)
        BigDecimal result = fractionalPart.multiply(new BigDecimal(m));

        // Floor the result to get bucket index
        return result.intValue();
    }

    public void insert(T value) {
        // Extract the key from the value
        int key = extractKey.apply(value);

        // Hash the key to get bucket index
        int index = hash(key);

        // Insert at the front of the linked list in that bucket
        data[index].insertInFront(value);
    }

    public T search(int key) {
        // Hash the key to find the bucket
        int index = hash(key);

        // Search through the linked list in that bucket
        Node<T> current = data[index].getHead();

        while (current != null) {
            // Check if this node's key matches what we're looking for
            if (extractKey.apply(current.getData()) == key) {
                return current.getData();
            }
            current = current.getNext();
        }

        // Not found
        return null;
    }

    public void delete(T value) {
        var index = extractKey.apply(value);
        data[index].delete(value);
    }
}
