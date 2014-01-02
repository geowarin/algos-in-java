package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 01/01/14 16:42
 */
public class DepthFirstPathFinder extends BasePathFinder {

    @Override
    protected void search() {
        searchDepthFirst(sourceVertex);
    }

    private void searchDepthFirst(int vertex) {
        marked[vertex] = true;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if (!marked[adjacentVertex]) {
                reachableFrom[adjacentVertex] = vertex;
                searchDepthFirst(adjacentVertex);
            }
        }
    }
}
