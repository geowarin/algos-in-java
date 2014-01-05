package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 01/01/14 16:25
 */
public interface PathFinder {
    void init(UndirectedGraph<Integer> graph, int sourceVertex);

    boolean hasPathTo(int vertex);

    Iterable<Integer> getPathTo(int vertex);
}
