package com.algos.structure.graph;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 02/01/14 00:09
 */
public class BreadthFirstPathFinderTest extends GraphTestCase {
    private BreadthFirstPathFinder pathFinder;

    @Before
    public void setUp() throws IOException {
        super.setUp("tinyG.txt");
        pathFinder = new BreadthFirstPathFinder();
        pathFinder.init(graph, 0);
    }

    @Test
    public void testPathTo() throws Exception {
        assertThat(pathFinder).pathToIsNull(6);
        assertThat(pathFinder).pathToEquals(5, new int[]{0, 5});
        assertThat(pathFinder).pathToEquals(0, new int[]{0});
    }
}
