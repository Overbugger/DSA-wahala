package com.endpoint.DS.LinkedList;

public class Node<T extends Comparable<T>> {
    private final T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void append(Node<T> newNode) {
        newNode.next = this.next;
        this.next = newNode;
    }

}
