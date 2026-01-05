package com.endpoint.DS.Containers;

import com.endpoint.DS.LinkedList.Node;
import com.endpoint.DS.LinkedList.SinglyLinkedList;

public class Stack <T extends Comparable<T>>{
    private SinglyLinkedList<T> data;

    public Stack() {
        this.data = new SinglyLinkedList<>();
    }

    public void push(T value) {
        data.insertInFront(value);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot pop.");
        }
        Node<T> top = data.getHead();
        data.delete(top.getData());
        return top.getData();
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot peek.");
        }
        return data.getHead().getData();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
