package com.algos.structure.graph;

import com.algos.structure.simple.ExtensibleQueue;
import com.algos.structure.simple.Queue;

/**
 * @author Sennen
 * @since 01/01/14 23:31
 */
public class BreadthFirstPathFinder extends BasePathFinder {

    @Override
    protected void search() {
        Queue<Integer> verticesToExplore = new ExtensibleQueue<>();
        verticesToExplore.enqueue(sourceVertex);
        while(!verticesToExplore.isEmpty()) {
            Integer vertexToExplore = verticesToExplore.dequeue();
            marked[vertexToExplore] = true;
            for (Integer adjacentVertex : graph.getAdjacentVertices(vertexToExplore)) {
                if(!marked[adjacentVertex]) {
                    reachableFrom[adjacentVertex] = vertexToExplore;
                    verticesToExplore.enqueue(adjacentVertex);
                }
            }
        }
    }
}
