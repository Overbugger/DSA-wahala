package com.endpoint.DS.Containers;

import com.endpoint.DS.LinkedList.DoublyLinkedList;

public class LLQueue<T extends Comparable<T>> {
    private DoublyLinkedList<T> data;

    public LLQueue() {
        this.data = new DoublyLinkedList<>();
    }

    public void enqueue(T value) {
        data.insertAtBack(value);
    }

    public void dequeue() {
        data.deleteFromFront();
    }

    public void printQueue() {
        data.printList();
    }
}
