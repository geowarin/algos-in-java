package com.algos.structure.graph;

import junit.framework.TestCase;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sennen
 * @since 05/01/14 04:46
 */
public class ExtensibleUndirectedGraphTest {
    private UndirectedGraph<Integer> graph;

    @Before
    public void setUp() {
        this.graph = new ExtensibleUndirectedGraph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
    }

    @Test
    public void testNumberOfVertices() throws Exception {
        TestCase.assertEquals(4, graph.getNumberOfVertices());
    }

    @Test
    public void testNumberOfEdges() throws Exception {
        TestCase.assertEquals(4, graph.getNumberOfEdges());
    }

    @Test
    public void testAdjacentVertices() throws Exception {
        Assertions.assertThat(graph.getAdjacentVertices(0)).containsOnly(1, 3);
    }
}
