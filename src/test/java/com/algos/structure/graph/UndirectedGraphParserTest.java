package com.algos.structure.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * @author Sennen
 * @since 31/12/13 15:46
 */
public class UndirectedGraphParserTest {
    @Test
    public void testParseToIntegerGraph() throws Exception {
        UndirectedGraph<Integer> undirectedGraph =
                UndirectedGraphParser.parseToIntegerGraph(
                        UndirectedGraphParserTest.class.getResource("simpleGraph.txt").getPath());
        assertEquals(13, undirectedGraph.getNumberOfEdges());
        Iterable<Integer> adjacentVertices = undirectedGraph.getAdjacentVertices(7);
        adjacentVertices.forEach(adjacentVertex -> assertEquals(8, adjacentVertex.intValue()));
        adjacentVertices = undirectedGraph.getAdjacentVertices(8);
        adjacentVertices.forEach(adjacentVertex -> assertEquals(7, adjacentVertex.intValue()));
    }

    @Test
    public void testParseToStringGraph() throws Exception {
        UndirectedSymbolGraph<String> undirectedGraph =
                UndirectedGraphParser.parseToStringGraph(
                        UndirectedGraphParserTest.class.getResource("simpleStringGraph.txt").getPath(), "/");
        assertEquals(2, undirectedGraph.getNumberOfEdges());
        assertEquals(4, undirectedGraph.getNumberOfVertices());
        Iterable<String> adjacentVertices = undirectedGraph.getAdjacentVertices("Sennen");
        adjacentVertices.forEach(adjacentVertex -> assertEquals("Nini", adjacentVertex));
        adjacentVertices = undirectedGraph.getAdjacentVertices("Papa");
        adjacentVertices.forEach(adjacentVertex -> assertEquals("Maman", adjacentVertex));
    }
}
