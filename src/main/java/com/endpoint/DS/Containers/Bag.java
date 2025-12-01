package com.endpoint.DS.Containers;

import com.endpoint.DS.LinkedList.SinglyLinkedList;

public class Bag <T extends Comparable<T>> {
    private final SinglyLinkedList<T> data;

    public Bag() {
        this.data = new SinglyLinkedList<>();
    }

    public void insert(T value) {
        data.insertInFront(value);
    }

    public void traverse() {
        data.printList();
    }
}
