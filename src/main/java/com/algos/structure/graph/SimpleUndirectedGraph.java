package com.algos.structure.graph;

import com.algos.structure.simple.Bag;
import com.algos.structure.simple.LinkedListBag;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 29/12/13 22:05
 */
public class SimpleUndirectedGraph implements UndirectedGraph {
    private final int numberOfVertices;
    private final Bag<Integer>[] adjacencyLists;
    private int numberOfEdges;

    public SimpleUndirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyLists = (Bag<Integer>[]) new Bag[numberOfVertices];
        Arrays.setAll(adjacencyLists, index -> new LinkedListBag<>());
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public void addEdge(int vertex, int otherVertex) {
        if(adjacencyLists[vertex].contains(otherVertex)) {
            return;
        }
        adjacencyLists[vertex].add(otherVertex);
        if (vertex != otherVertex) {
            adjacencyLists[otherVertex].add(vertex);
        }
        numberOfEdges++;
    }

    @Override
    public Iterable<Integer> getAdjacentVertices(int vertex) {
        return adjacencyLists[vertex];
    }

    @Override
    public String toString() {
        int numberOfVertices = getNumberOfVertices();
        String s = numberOfVertices + " vertices, " + getNumberOfEdges() + " edges\n";
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            s += vertex + ": ";
            for (int adjacentVertex : getAdjacentVertices(vertex)) {
                s += adjacentVertex + " ";
            }
            s += "\n";
        }
        return s;
    }
}
