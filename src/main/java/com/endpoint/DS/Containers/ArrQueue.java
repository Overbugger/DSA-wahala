package com.endpoint.DS.Containers;

public class ArrQueue<T extends Comparable<T>> {
    private T[] data;
    private int maxSize;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrQueue(int maxSize) {
        this.data = (T[]) new Comparable[maxSize];
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(T value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("The queue is full");
        }

        this.data[rear] = value;
        this.rear = (this.rear + 1) % this.maxSize;
        this.size++;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }

        T value = this.data[front];
        this.data[front] = null;
        this.front = (this.front + 1) % this.maxSize;
        this.size --;
        return value;
    }

    public T peek() {
        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return this.data[front];
    }

    public int length() {
       return this.size;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public boolean isFull() {
        return length() == this.maxSize;
    }

}
