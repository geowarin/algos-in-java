package com.algos.structure.graph;

/**
 * @author Sennen
 * @since 01/01/14 13:08
 */
public class DepthFirstGraphSearch implements GraphSearch {
    private UndirectedGraph<Integer> graph;
    private boolean[] marked;
    private int count;

    @Override
    public void init(UndirectedGraph<Integer> graph, int sourceVertex) {
        this.graph = graph;
        marked = new boolean[graph.getNumberOfVertices()];
        searchDepthFirst(sourceVertex);
    }

    private void searchDepthFirst(int vertex) {
        marked[vertex] = true;
        count++;
        for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if(!marked[adjacentVertex]) {
                searchDepthFirst(adjacentVertex);
            }
        }
    }

    @Override
    public boolean marked(int vertex) {
        return marked[vertex];
    }

    @Override
    public int count() {
        return count;
    }
}
