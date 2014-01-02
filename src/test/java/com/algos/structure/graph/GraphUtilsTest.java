package com.algos.structure.graph;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 31/12/13 16:11
 */
public class GraphUtilsTest extends GraphTestCase {
    @Before
    public void setUp() throws IOException {
        super.setUp("simpleGraph.txt");
    }

    @Test
    public void testDegree() throws Exception {
        TestCase.assertEquals(4, GraphUtils.getDegree(graph, 0));
    }

    @Test
    public void testMaxDegree() throws Exception {
        TestCase.assertEquals(4, GraphUtils.getMaxDegree(graph));

    }

    @Test
    public void testMinDegree() throws Exception {
        TestCase.assertEquals(1, GraphUtils.getMinDegree(graph));
    }

    @Test
    public void testAverageDegree() throws Exception {
        TestCase.assertEquals(2, GraphUtils.getAverageDegree(graph));
    }

    @Test
    public void testNumberOfSelfLoops() throws Exception {
        TestCase.assertEquals(0, GraphUtils.getNumberOfSelfLoops(graph));
        graph.addEdge(0, 0);
        TestCase.assertEquals(1, GraphUtils.getNumberOfSelfLoops(graph));

    }
}
