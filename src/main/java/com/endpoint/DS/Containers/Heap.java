package com.endpoint.DS.Containers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Heap<T> {

    private List<T> elements;
    private Function<T, ? extends Comparable> priority;

    // Constructor with elements and custom priority function
    public Heap(List<T> elements, Function<T, ? extends Comparable> elementPriority) {
        this.priority = elementPriority;
        if (elements != null && !elements.isEmpty()) {
            heapify(elements);
        } else {
            this.elements = new ArrayList<>();
        }
    }

    // Constructor with elements only (uses natural ordering)
    public Heap(List<T> elements) {
        this(elements, x -> (Comparable) x);
    }

    // Constructor with custom priority function only
    public Heap(Function<T, ? extends Comparable> elementPriority) {
        this(null, elementPriority);
    }

    // Default constructor
    public Heap() {
        this(null, x -> (Comparable) x);
    }

    private void heapify(List<T> elements) {
        this.elements = new ArrayList<>(elements);
        for (int i = this.elements.size() / 2 - 1; i >= 0; i--) {
            pushDown(i);
        }
    }

    // Getter for elements
    public List<T> getElements() {
        return elements;
    }

    public void insert(T element) {
        elements.add(element);
        bubbleUp(elements.size() - 1);
    }

    public T top() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Method top called on an empty heap.");
        }

        T element = elements.get(0);

        if (elements.size() == 1) {
            elements.remove(0);
        } else {
            elements.set(0, elements.get(elements.size() - 1));
            elements.remove(elements.size() - 1);
            pushDown(0);
        }

        return element;
    }

    private int highestPriorityChildIndex(int index) {
        int leftIndex = leftChildIndex(index);

        // No children
        if (leftIndex >= elements.size()) {
            return -1;
        }

        int rightIndex = leftIndex + 1;

        // Only left child exists
        if (rightIndex >= elements.size()) {
            return leftIndex;
        }

        // Both children exist - return the one with higher priority
        if (hasHigherPriority(elements.get(leftIndex), elements.get(rightIndex))) {
            return leftIndex;
        } else {
            return rightIndex;
        }
    }

    private void pushDown(int index) {
        T element = elements.get(index);

        while (true) {
            int childIndex = highestPriorityChildIndex(index);

            // No children left
            if (childIndex == -1) {
                break;
            }

            T child = elements.get(childIndex);

            // If child has higher priority, swap and continue
            if (hasHigherPriority(child, element)) {
                elements.set(index, child);
                index = childIndex;
            } else {
                break;
            }
        }

        elements.set(index, element);
    }

    private void bubbleUp(int index) {
        T element = elements.get(index);
        while(index > 0) {
            int parentIndex = parentIndex(index);
            T parent = elements.get(parentIndex);
            if (hasHigherPriority(element, parent)) {
                elements.set(index, parent);
                index = parentIndex;
            } else {
                break;
            }
        }
        elements.set(index, element);
    }

    @SuppressWarnings("unchecked")
    private int compare(T element1, T element2) {
        Comparable priority1 = priority.apply(element1);
        Comparable priority2 = priority.apply(element2);
        return priority1.compareTo(priority2);
    }

    private boolean hasLowerPriority(T element1, T element2) {
        return compare(element1, element2) < 0;
    }

    private boolean hasHigherPriority(T element1, T element2) {
        return compare(element1, element2) > 0;
    }

    // Helper methods for navigating the heap tree structure
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
}
