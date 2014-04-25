package com.algos.structure.graph;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Sennen
 * @since 01/01/14 13:12
 */
public class DepthFirstGraphSearchTest extends GraphTestCase {
    private DepthFirstGraphSearch graphSearch;

    @Before
    public void setUp() throws IOException {
        super.setUp("simpleGraph.txt");
        graphSearch = new DepthFirstGraphSearch();
        graphSearch.init(graph, 0);
    }

    @Test
    public void testConnections() throws Exception {
        Boolean[] expectedConnections =
                {true, true, true, true, true, true, true, false, false, false, false, false, false};
        Boolean[] actualConnections = new Boolean[graph.getNumberOfVertices()];
        Arrays.setAll(actualConnections, graphSearch::marked);
        Assertions.assertThat(actualConnections).isEqualTo(expectedConnections);
    }
}
