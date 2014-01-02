package com.algos.structure.graph;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 01/01/14 17:10
 */
public class DepthFirstPathFinderTest extends GraphTestCase {
    private DepthFirstPathFinder pathFinder;

    @Before
    public void setUp() throws IOException {
        super.setUp("tinyCG.txt");
        pathFinder = new DepthFirstPathFinder();
        pathFinder.init(graph, 0);
    }

    @Test
    public void testPathTo() throws Exception {
        assertThat(pathFinder).pathToIsNull(6);
        assertThat(pathFinder).pathToEquals(5, new int[]{0, 2, 3, 5});
        assertThat(pathFinder).pathToEquals(0, new int[]{0});
    }
}
