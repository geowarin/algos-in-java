package com.algos.structure.graph;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Sennen
 * @since 03/01/14 18:29
 */
public class BipartiteGraphDetectorTest {
    @Test
    public void testIsBipartite() throws Exception {
        UndirectedGraph<Integer> graph =
                UndirectedGraphParser.parseToIntegerGraph(GraphTestCase.class.getResource("simpleBipartiteGraph.txt")
                                                                             .getPath());
        BipartiteGraphDetector bipartiteGraphDetector = new BipartiteGraphDetector(graph);
        TestCase.assertTrue(bipartiteGraphDetector.isBipartite());
        graph = UndirectedGraphParser.parseToIntegerGraph(GraphTestCase.class.getResource("complexBipartiteGraph.txt").getPath());
        bipartiteGraphDetector = new BipartiteGraphDetector(graph);
        TestCase.assertTrue(bipartiteGraphDetector.isBipartite());
    }

    @Test
    public void testIsNotBipartite() throws Exception {
        UndirectedGraph<Integer> graph =
                UndirectedGraphParser.parseToIntegerGraph(GraphTestCase.class.getResource("noBipartiteGraph.txt").getPath());
        BipartiteGraphDetector bipartiteGraphDetector = new BipartiteGraphDetector(graph);
        TestCase.assertFalse(bipartiteGraphDetector.isBipartite());
    }
}
