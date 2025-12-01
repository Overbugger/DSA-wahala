package com.endpoint.DS.Trees;

import com.endpoint.DS.LinkedList.SinglyLinkedList;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

    private final int id;
    private final SinglyLinkedList<Vertex<T>> adjacentList;

    public Vertex (int key) {
        this.id = key;
        this.adjacentList = new SinglyLinkedList<>();
    }

    /** Check if this vertex already has an edge to destination */
    public boolean hasEdgeTo(Vertex<T> destination) {
        return adjacentList.search(destination) != null;
    }

    /** Add an edge to the adjacency list */
    public void addEdgeTo(Vertex<T> destination) {
        if (hasEdgeTo(destination)) {
            throw new IllegalArgumentException(
                    "Edge already exists: " + this + " -> " + destination
            );
        }

        adjacentList.insertInFront(destination);
    }

    @Override
    public String toString() {
        return "Vertex(" + id + ")";
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return 0;
    }
}
