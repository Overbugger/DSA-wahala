package com.endpoint.DS.Containers;

import com.endpoint.DS.LinkedList.SinglyLinkedList;

public class Stack <T extends Comparable<T>>{
    private SinglyLinkedList<T> data;

    public Stack() {
        this.data = new SinglyLinkedList<>();
    }

    public void push(T value) {
        data.insertInFront(value);
    }

    public void pop(T value) {
        if(data.isEmpty()){
            throw new IllegalStateException("Stack is empty! Cannot pop.");
        }
        data.delete(value);
    }
}
