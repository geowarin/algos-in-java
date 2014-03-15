package com.algos.structure.graph;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Sennen
 * @since 03/01/14 03:39
 */
public class GraphCycleDetectorTest {
    @Test
    public void testHasCycle() throws Exception {
        UndirectedGraph<Integer> graph =
                UndirectedGraphParser.parseToIntegerGraph(GraphTestCase.class.getResource("simpleGraph.txt").getPath());
        GraphCycleDetector graphCycleDetector = new GraphCycleDetector(graph);
        TestCase.assertTrue(graphCycleDetector.hasCycle());
    }

    @Test
    public void testHasNoCycle() throws Exception {
        UndirectedGraph<Integer> graph =
                UndirectedGraphParser.parseToIntegerGraph(GraphTestCase.class.getResource("noCycleGraph.txt").getPath());
        GraphCycleDetector graphCycleDetector = new GraphCycleDetector(graph);
        TestCase.assertFalse(graphCycleDetector.hasCycle());
    }
}
