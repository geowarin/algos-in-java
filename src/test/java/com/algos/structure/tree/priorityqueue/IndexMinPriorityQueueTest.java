package com.algos.structure.tree.priorityqueue;

import com.algos.structure.tree.priorityqueue.IndexMinPriorityQueue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.*;

/**
 * User: sennen
 * Date: 18/03/2014
 * Time: 13:11
 */
public class IndexMinPriorityQueueTest {

    private IndexMinPriorityQueue<Character> minPriorityQueue;

    @Before
    public void setUp() {
        minPriorityQueue = new IndexMinPriorityQueue<>(Character[]::new);
        minPriorityQueue.insert(1, 'Z');
        minPriorityQueue.insert(4, 'U');
        minPriorityQueue.insert(2, 'Y');
        minPriorityQueue.insert(3, 'S');
    }

    @Test
    public void testOrderedByDescendantIndex() throws Exception {
        assertEquals('Z', minPriorityQueue.peek().charValue());
        assertEquals(1, minPriorityQueue.peekIndex());
        assertEquals('Z', minPriorityQueue.poll().charValue());
        assertEquals('Y', minPriorityQueue.poll().charValue());
        assertEquals('S', minPriorityQueue.poll().charValue());
        assertEquals('U', minPriorityQueue.poll().charValue());
    }

    @Test
    public void testInsertPriorityAlreadyInHasNoEffect() throws Exception {
        assertEquals('Z', minPriorityQueue.peek().charValue());
        assertEquals(1, minPriorityQueue.peekIndex());
        minPriorityQueue.insert(1, 'H');
        assertEquals('Z', minPriorityQueue.peek().charValue());
        assertEquals(1, minPriorityQueue.peekIndex());
    }

    @Test
    public void testUpdate() throws Exception {
        assertFalse(minPriorityQueue.contains(10));
        minPriorityQueue.update(10, 'O');
        assertFalse(minPriorityQueue.contains(10));
    }

    @Test
    public void testUpdateNonExistingHasNoEffect() throws Exception {
        minPriorityQueue.update(1, 'O');
        assertEquals('O', minPriorityQueue.poll().charValue());
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(minPriorityQueue.contains(2));
        minPriorityQueue.delete(2);
        assertFalse(minPriorityQueue.contains(2));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(4, minPriorityQueue.size());
        minPriorityQueue.delete(4);
        assertEquals(3, minPriorityQueue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(minPriorityQueue.isEmpty());
        minPriorityQueue.poll();
        minPriorityQueue.poll();
        minPriorityQueue.poll();
        minPriorityQueue.poll();
        assertTrue(minPriorityQueue.isEmpty());
    }
}
