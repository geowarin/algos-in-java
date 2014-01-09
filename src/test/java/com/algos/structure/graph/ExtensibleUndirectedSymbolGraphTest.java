package com.algos.structure.graph;

import junit.framework.TestCase;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 05/01/14 04:46
 */
public class ExtensibleUndirectedSymbolGraphTest {
    private UndirectedSymbolGraph<String> graph;

    @Before
    public void setUp() throws IOException {
        this.graph =
                UndirectedGraphParser.parseToStringGraph(
                        ExtensibleUndirectedGraphTest.class.getResource("routes.txt").getPath(),
                        " ");
    }

    @Test
    public void testNumberOfVertices() throws Exception {
        TestCase.assertEquals(10, graph.getNumberOfVertices());
    }

    @Test
    public void testAdjacentVertices() throws Exception {
        Assertions.assertThat(graph.getAdjacentVertices("JFK")).containsOnly("ORD", "ATL", "MCO");
        Assertions.assertThat(graph.getAdjacentVertices("HOU")).containsOnly("MCO", "ORD", "ATL", "DFW");
    }
}
