package com.algos.structure.graph;

import org.junit.Test;

import java.util.function.Consumer;

import static junit.framework.TestCase.assertEquals;


/**
 * @author Sennen
 * @since 31/12/13 15:46
 */
public class UndirectedGraphParserTest {
    @Test
    public void testParse() throws Exception {
        UndirectedGraph undirectedGraph =
                UndirectedGraphParser.parse(UndirectedGraphParserTest.class.getResource("simpleGraph.txt").getPath());
        assertEquals(13, undirectedGraph.getNumberOfEdges());
        Iterable<Integer> adjacentVertices = undirectedGraph.getAdjacentVertices(7);
        adjacentVertices.forEach(adjacentVertex -> assertEquals(8, adjacentVertex.intValue()));
        adjacentVertices = undirectedGraph.getAdjacentVertices(8);
        adjacentVertices.forEach(adjacentVertex -> assertEquals(7, adjacentVertex.intValue()));
    }
}
