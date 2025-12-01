package com.endpoint.DS.LinkedList;

public class DllNode <T extends Comparable<T>>{
    private T data;
    private DllNode<T> next;
    private DllNode<T> prev;

    public DllNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DllNode<T> getNext() {
        return next;
    }

    public void setNext(DllNode<T> next) {
        this.next = next;
    }

    public DllNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DllNode<T> prev) {
        this.prev = prev;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public void append(DllNode<T> newNode) {
        this.next = newNode;
        if(newNode != null) {
            newNode.prev = this;
        }
    }

    public void prepend(DllNode<T> newNode) {
        this.prev = newNode;
        if (newNode != null) {
            newNode.next = this;
        }
    }

}
