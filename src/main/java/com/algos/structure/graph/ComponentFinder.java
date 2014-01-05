package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 02/01/14 12:41
 */
public interface ComponentFinder {
    default boolean connected(int vertex, int otherVertex) {
        return getComponentId(vertex) == getComponentId(otherVertex);
    }

    int getNumberOfComponents();

    int getComponentId(int vertex);
}
