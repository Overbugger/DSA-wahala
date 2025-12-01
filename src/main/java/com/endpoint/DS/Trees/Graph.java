package com.endpoint.DS.Trees;

import java.util.HashMap;
import java.util.Map;

public class Graph<T extends Comparable<T>> {
    private final Map<Integer, Vertex<T>> adj;

    public Graph() {
        this.adj = new HashMap<>();
    }

    public Vertex<T> getVertex(int id) {
        return adj.get(id);
    }

    public void addVertex(int id) {
        if (adj.containsKey(id)) {
            throw new IllegalArgumentException("Vertex already exists: " + id);
        }
        adj.put(id, new Vertex<>(id));
    }

    /** Add a directed edge: id1 -> id2 */
    public void addEdge(int fromId, int toId) {
        Vertex<T> from = adj.get(fromId);
        Vertex<T> to = adj.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both vertices not found.");
        }

        from.addEdgeTo(to);
    }
}
