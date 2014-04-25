package com.algos.structure.graph;

import java.util.function.BinaryOperator;

/**
 * @author Sennen
 * @since 25/12/13 22:37
 */
public abstract class GraphUtils {
    public static int getDegree(UndirectedGraph<Integer> graph, int vertex) {
        return getSize(graph.getAdjacentVertices(vertex));
    }

    public static int getMaxDegree(UndirectedGraph<Integer> graph) {
        return getExtremeDegree(graph, Math::max);
    }

    public static int getMinDegree(UndirectedGraph<Integer> graph) {
        return getExtremeDegree(graph, Math::min);
    }

    public static int getAverageDegree(UndirectedGraph<Integer> graph) {
        return 2 * graph.getNumberOfVertices() / graph.getNumberOfEdges();
    }

    public static int getNumberOfSelfLoops(UndirectedGraph<Integer> graph) {
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

    public static <T> int getSeparationDegree(UndirectedSymbolGraph<T> graph, T source, T destination) {
        for (T adjacentVertex : graph.getAdjacentVertices(source)) {
            System.out.print(adjacentVertex + " ");
        }
        System.out.println();
        BreadthFirstPathFinder shortestPathFinder = new BreadthFirstPathFinder();
        shortestPathFinder.init(graph.getUnderlyingGraph(), graph.getIndex(source));
        Iterable<Integer> shortestPath = shortestPathFinder.getPathTo(graph.getIndex(destination));
        return getSize(shortestPath) - 1;
    }

    private static int getSize(Iterable<Integer> integers) {
        Counter counter = new Counter();
        integers.iterator().forEachRemaining(integer -> counter.add());
        return counter.size;
    }

    private static int getExtremeDegree(UndirectedGraph<Integer> graph, BinaryOperator<Integer> operator) {
        Integer extremeDegree = null;
        for (int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++) {
            int degree = getDegree(graph, vertex);
            extremeDegree = extremeDegree == null ? degree : operator.apply(extremeDegree, degree);
        }
        if (extremeDegree == null) {
            throw new IllegalArgumentException("Graph contains no vertex");
        }
        return extremeDegree;
    }

    private static class Counter {
        int size;

        private void add() {
            size++;
        }
    }
}
