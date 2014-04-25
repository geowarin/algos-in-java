package com.algos.structure.graph;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 03/01/14 17:57
 */
public class BipartiteGraphDetector {
    private final UndirectedGraph<Integer> graph;
    private final boolean[] marked;
    private final Color[] colors;
    private boolean isBipartite = true;

    public BipartiteGraphDetector(UndirectedGraph<Integer> graph) {
        this.graph = graph;
        colors = new Color[graph.getNumberOfVertices()];
        Arrays.setAll(colors, index -> Color.BLACK);
        marked = new boolean[graph.getNumberOfVertices()];
        for (int vertex = 0; vertex < graph.getNumberOfVertices() && isBipartite; vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex, colors[vertex]);
            }
        }
    }

    private void depthFirstSearch(int vertex, Color color) {
        if(!isBipartite) {
            return;
        }
        marked[vertex] = true;
        colors[vertex] = color;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if(!marked[adjacentVertex]) {
                depthFirstSearch(adjacentVertex, Color.getOpposite(color));
            }
            else if(color == colors[adjacentVertex]) {
                isBipartite = false;
                return;
            }
        }

    }

    public boolean isBipartite() {
        return isBipartite;
    }

    private static enum Color {
        BLACK, RED;

        private static Color getOpposite(Color color) {
            if(RED.equals(color)) {
                return BLACK;
            }
            return RED;
        }
    }
}
