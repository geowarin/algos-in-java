package com.algos.structure.graph;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Sennen
 * @since 03/01/14 02:46
 */
public class DepthFirstComponentFinderTest extends GraphTestCase {
    private DepthFirstComponentFinder componentFinder;

    @Before
    public void setUp() throws IOException {
        super.setUp("simpleGraph.txt");
        this.componentFinder = new DepthFirstComponentFinder(graph);
    }

    @Test
    public void testNumberOfComponents() throws Exception {
        assertEquals(3, componentFinder.getNumberOfComponents());
    }

    @Test
    public void testComponentId() throws Exception {
        assertEquals(0, componentFinder.getComponentId(0));
        assertEquals(0, componentFinder.getComponentId(1));
        assertEquals(0, componentFinder.getComponentId(2));
        assertEquals(0, componentFinder.getComponentId(3));
        assertEquals(0, componentFinder.getComponentId(4));
        assertEquals(0, componentFinder.getComponentId(5));
        assertEquals(0, componentFinder.getComponentId(6));
        assertEquals(1, componentFinder.getComponentId(7));
        assertEquals(1, componentFinder.getComponentId(8));
        assertEquals(2, componentFinder.getComponentId(9));
        assertEquals(2, componentFinder.getComponentId(10));
        assertEquals(2, componentFinder.getComponentId(11));
        assertEquals(2, componentFinder.getComponentId(12));
    }

    @Test
    public void testIsConnected() throws Exception {
        TestCase.assertTrue(componentFinder.connected(0, 1));
        TestCase.assertFalse(componentFinder.connected(0, 7));
    }
}
