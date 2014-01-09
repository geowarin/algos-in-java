package com.algos.structure.graph;

import com.algos.structure.simple.Bag;
import com.algos.structure.simple.LinkedListBag;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 05/01/14 03:40
 */
public class ExtensibleUndirectedGraph implements UndirectedGraph<Integer> {
    private Bag<Integer>[] adjacencyLists;
    private int numberOfEdges;

    @Override
    public int getNumberOfVertices() {
        return adjacencyLists.length;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public void addEdge(Integer vertex, Integer otherVertex) {
        updateAdjacencyList(Math.max(vertex, otherVertex) + 1);
        if (adjacencyLists[vertex].contains(otherVertex)) {
            return;
        }
        adjacencyLists[vertex].add(otherVertex);
        if (!vertex.equals(otherVertex)) {
            adjacencyLists[otherVertex].add(vertex);
        }
        numberOfEdges++;
    }

    @Override
    public Iterable<Integer> getAdjacentVertices(Integer vertex) {
        return adjacencyLists[vertex];
    }

    private void updateAdjacencyList(int size) {
        if (adjacencyLists == null) {
            adjacencyLists = (Bag<Integer>[]) new Bag[size];
            Arrays.setAll(adjacencyLists, index -> new LinkedListBag<>());
        } else if (size > adjacencyLists.length) {
            adjacencyLists = Arrays.copyOf(adjacencyLists, size);
            Arrays.setAll(adjacencyLists, index -> adjacencyLists[index] != null ?
                                                   adjacencyLists[index] :
                                                   new LinkedListBag<>());
        }
    }
}
