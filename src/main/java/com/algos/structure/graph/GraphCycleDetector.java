package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 03/01/14 03:23
 */
public class GraphCycleDetector {
    private final UndirectedGraph<Integer> graph;
    private boolean hasCycle;
    private final boolean[] marked;

    public GraphCycleDetector(UndirectedGraph<Integer> graph) {
        this.graph = graph;
        int numberOfVertices = graph.getNumberOfVertices();
        marked = new boolean[numberOfVertices];
        for (int vertex = 0; vertex < numberOfVertices && !hasCycle; vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex, vertex);
            }
        }
    }

    private void depthFirstSearch(int rootVertex, int vertex) {
        if (hasCycle) {
            return;
        }
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(vertex, adjacentVertex);
            } else if (adjacentVertex != rootVertex) {
                hasCycle = true;
                return;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
