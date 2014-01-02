package com.algos.structure.graph;

import com.algos.structure.simple.ExtensibleStack;
import com.algos.structure.simple.Stack;

/**
 * @author Sennen
 * @since 01/01/14 23:43
 */
public abstract class BasePathFinder implements PathFinder {
    protected UndirectedGraph graph;
    protected int sourceVertex;
    protected boolean[] marked;
    protected int[] reachableFrom;

    @Override
    public void init(UndirectedGraph graph, int sourceVertex) {
        this.graph = graph;
        this.sourceVertex = sourceVertex;
        marked = new boolean[graph.getNumberOfVertices()];
        reachableFrom = new int[graph.getNumberOfVertices()];
        search();
    }

    protected abstract void search();

    @Override
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    @Override
    public Iterable<Integer> getPathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        Stack<Integer> path = new ExtensibleStack<>();
        for (int currentVertex = vertex; currentVertex != sourceVertex; currentVertex = reachableFrom[currentVertex]) {
            path.push(currentVertex);
        }
        path.push(sourceVertex);
        return path;
    }
}
