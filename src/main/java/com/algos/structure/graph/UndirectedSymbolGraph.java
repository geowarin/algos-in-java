package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 05/01/14 03:12
 */
public interface UndirectedSymbolGraph<T> extends UndirectedGraph<T> {
    boolean contains(T key);

    UndirectedGraph<Integer> getUnderlyingGraph();

    int getIndex(T vertex);

    T getVertex(int index);
}
