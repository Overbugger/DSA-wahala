package com.endpoint.DS.LinkedList;

public class DoublyLinkedList<T extends  Comparable<T>> {
    DllNode<T> head;
    DllNode<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DllNode<T> getHead() {
        return head;
    }

    public void setHead(DllNode<T> head) {
        this.head = head;
    }

    public DllNode<T> getTail() {
        return tail;
    }

    public void setTail(DllNode<T> tail) {
        this.tail = tail;
    }

    public void insertInFront(T data) {
        if(head == null) {
            head = tail = new DllNode<>(data);
        }else {
            var oldHead = head;
            head = new DllNode<>(data);
            head.append(oldHead);
        }
    }

    public void deleteFromFront() {
        if(head == null){
            throw new IllegalStateException("No element to delete");
        }

        var oldHead = head;
        if(oldHead.getNext() == null) {
            head = null;
        }else {
        head = oldHead.getNext();
        }
    }

    public void insertAtBack(T data) {
        if(tail == null) {
            tail = head =  new DllNode<>(data);
        }else {
         var oldTail = tail;
         tail = new DllNode<>(data);
         tail.prepend(oldTail);
        }
    }

    public void printList() {
        DllNode<T> current = head;
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }

        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
