package com.algos.structure.graph;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author Sennen
 * @since 02/01/14 00:14
 */
public class GraphTestCase {
    protected UndirectedGraph graph;

    protected void setUp(String fileName) throws IOException {
        graph = UndirectedGraphParser.parse(GraphTestCase.class.getResource(fileName).getPath());
    }

    protected PathFinderAssertion assertThat(PathFinder pathFinder) {
        return new PathFinderAssertion(pathFinder);
    }

    protected static class PathFinderAssertion {
        private final PathFinder pathFinder;

        private PathFinderAssertion(PathFinder pathFinder) {
            this.pathFinder = pathFinder;
        }

        protected void pathToIsNull(int vertex) {
            TestCase.assertNull(pathFinder.getPathTo(vertex));
        }

        protected void pathToEquals(int vertex, int[] expectedPathFrom0To5) {
            int index = 0;
            for (Integer actualVertex : pathFinder.getPathTo(vertex)) {
                TestCase.assertEquals(actualVertex.intValue(), expectedPathFrom0To5[index]);
                index++;
            }
        }
    }
}
