package com.endpoint;

import com.endpoint.DS.Containers.Heap;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Example 4: Task Priority Queue ===");
        taskPriorityQueue();
    }

    private static void taskPriorityQueue() {
        Heap<Integer> arrQueue = new Heap<>();

        arrQueue.insert(1);
        arrQueue.insert(5);
        arrQueue.insert(67);
        arrQueue.insert(9);
        arrQueue.insert(87);
        arrQueue.insert(3);
        arrQueue.insert(2);




//        // Add tasks with different priorities
//        taskQueue.insert(new Task("Fix critical bug", 10));
//        taskQueue.insert(new Task("Write documentation", 3));
//        taskQueue.insert(new Task("Review PR", 7));
//        taskQueue.insert(new Task("Deploy to production", 9));
//        taskQueue.insert(new Task("Update dependencies", 4));
//
//        System.out.println("Processing tasks by priority:");
        while (!arrQueue.getElements().isEmpty()) {
            var top = arrQueue.top();
            System.out.println(top);
        }
    }

    static class Task {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return name + " (priority: " + priority + ")";
        }
    }
}