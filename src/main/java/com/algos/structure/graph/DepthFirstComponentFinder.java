package com.algos.structure.graph;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 03/01/14 00:08
 */
public class DepthFirstComponentFinder implements ComponentFinder {
    private final boolean[] marked;
    private final int[] componentIds;
    private int numberOfComponents;

    public DepthFirstComponentFinder(UndirectedGraph<Integer> graph) {
        marked = new boolean[graph.getNumberOfVertices()];
        componentIds = new int[graph.getNumberOfVertices()];
        Arrays.setAll(componentIds, index -> index);
        for (int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(graph, vertex);
                numberOfComponents++;
            }
        }
    }

    private void depthFirstSearch(UndirectedGraph<Integer> graph, int vertex) {
        marked[vertex] = true;
        componentIds[vertex] = numberOfComponents;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(graph, adjacentVertex);
            }
        }
    }

    @Override
    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    @Override
    public int getComponentId(int vertex) {
        return componentIds[vertex];
    }
}
