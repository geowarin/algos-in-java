package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 24/12/13 22:21
 */
public interface UndirectedGraph {
    int getNumberOfVertices();

    int getNumberOfEdges();

    void addEdge(int vertex, int otherVertex);

    Iterable<Integer> getAdjacentVertices(int vertex);
}
