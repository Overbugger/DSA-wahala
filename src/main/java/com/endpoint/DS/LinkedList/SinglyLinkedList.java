package com.endpoint.DS.LinkedList;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void insertToBack(T data) {
        if (head == null) {
            head = new Node<>(data);
        }
        else {
            Node<T> current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(new Node<>(data));
        }
    }

    public void insertInFront(T data) {
        Node<T> oldHead = head;
        head = new Node<>(data, oldHead);
    }

    public void insertSortedList(T newData) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.getData().compareTo(newData) >= 0) {
                if (previous == null) {
                    head = new Node<>(newData, current);
                } else {
                    previous.append(new Node<>(newData));
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = new Node<>(newData, null);
        } else {
            previous.append(new Node<>(newData, null));
        }
    }

    public Node<T> search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public void delete(T target) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.getData().equals(target)) {
                if (previous == null) {
                    head = current.getNext();
                }
                else {
                    previous.setNext(current.getNext());
                }
                return;
            }

            previous = current;
            current = current.getNext();
        }

        System.out.println("Value not found: " + target);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
