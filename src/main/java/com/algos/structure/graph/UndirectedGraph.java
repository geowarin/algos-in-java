package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 24/12/13 22:21
 */
public interface UndirectedGraph<T> {
    int getNumberOfVertices();

    int getNumberOfEdges();

    void addEdge(T vertex, T otherVertex);

    Iterable<T> getAdjacentVertices(T vertex);
}
