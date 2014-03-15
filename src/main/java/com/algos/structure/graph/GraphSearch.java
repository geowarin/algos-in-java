package com.algos.structure.graph;

/**
 *
 * @author Sennen
 * @since 01/01/14 13:00
 */
public interface GraphSearch {
    /**
     * A graph search is initialized with a graph and a vertex from which it begins exploration of the provided graph
     * @param graph Graph to explore
     * @param sourceVertex Vertex where exploration begins
     */
    void init(UndirectedGraph<Integer> graph, int sourceVertex);

    /**
     * Shows if a vertex is connected to main vertex.
     * @param vertex
     * @return true if it is connected, false otherwise.
     */
    boolean marked(int vertex);

    /**
     * @return The number of vertices connected to main vertex provided
     */
    int count();
}
