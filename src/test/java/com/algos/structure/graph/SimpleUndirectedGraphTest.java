package com.algos.structure.graph;

import junit.framework.TestCase;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 30/12/13 22:58
 */
public class SimpleUndirectedGraphTest extends GraphTestCase {
    @Before
    public void setUp() throws IOException {
        super.setUp("simpleGraph.txt");
    }

    @Test
    public void testNumberOfVertices() throws Exception {
        TestCase.assertEquals(13, graph.getNumberOfVertices());
    }

    @Test
    public void testNumberOfEdges() throws Exception {
        TestCase.assertEquals(13, graph.getNumberOfEdges());
    }

    @Test
    public void testAdjacentVertices() throws Exception {
        Iterable<Integer> adjacentVerticesOfZero = graph.getAdjacentVertices(0);
        Assertions.assertThat(adjacentVerticesOfZero).containsOnly(1, 2, 5, 6);
    }

    @Test
    public void testEdgeNotAddedTwice() throws Exception {
        TestCase.assertEquals(13, graph.getNumberOfEdges());
        graph.addEdge(0, 1);
        TestCase.assertEquals(13, graph.getNumberOfEdges());
    }
}
