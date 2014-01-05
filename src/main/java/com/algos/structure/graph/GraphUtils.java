package com.algos.structure.graph;

import java.util.function.BinaryOperator;

/**
 * @author Sennen
 * @since 25/12/13 22:37
 */
public abstract class GraphUtils {
    public static int getDegree(UndirectedGraph graph, int vertex) {
        int degree = 0;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            degree++;
        }
        return degree;
    }

    public static int getMaxDegree(UndirectedGraph graph) {
        return getExtremeDegree(graph, Math::max);
    }

    public static int getMinDegree(UndirectedGraph graph) {
        return getExtremeDegree(graph, Math::min);
    }

    public static int getAverageDegree(UndirectedGraph graph) {
        return 2 * graph.getNumberOfVertices() / graph.getNumberOfEdges();
    }

    public static int getNumberOfSelfLoops(UndirectedGraph graph) {
        int numberOfSelfLoops = 0;
        for (int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++) {
            for (int adjacentVertex : graph.getAdjacentVertices(vertex)) {
                if (vertex == adjacentVertex) {
                    numberOfSelfLoops++;
                }
            }
        }
        return numberOfSelfLoops;
    }

    private static int getExtremeDegree(UndirectedGraph graph, BinaryOperator<Integer> operator) {
        Integer extremeDegree = null;
        for (int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++) {
            int degree = getDegree(graph, vertex);
            extremeDegree = extremeDegree == null ? degree : operator.apply(extremeDegree, degree);
        }
        if(extremeDegree == null) {
            throw new IllegalArgumentException("Graph contains no vertex");
        }
        return extremeDegree;
    }
}
