package com.algos.structure.simple;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * User: sennen
 * Date: 16/03/2014
 * Time: 00:10
 */
public class MaxPriorityQueueTest {
    private MaxPriorityQueue<Character> priorityQueue;

    @Before
    public void setUp() {
        priorityQueue = new MaxPriorityQueue<>(Character[]::new);
        priorityQueue.insert('A');
        priorityQueue.insert('O');
        priorityQueue.insert('T');
        priorityQueue.insert('S');
        priorityQueue.insert('N');
        priorityQueue.insert('R');
        priorityQueue.insert('P');
    }

    @Test
    public void testItemsAreOrdered() throws Exception {
        assertEquals('T', priorityQueue.max().charValue());
        assertEquals('T', priorityQueue.delMax().charValue());
        assertEquals('S', priorityQueue.delMax().charValue());
        priorityQueue.insert('K');
        assertEquals('R', priorityQueue.delMax().charValue());
        assertEquals('P', priorityQueue.delMax().charValue());
        assertEquals('O', priorityQueue.delMax().charValue());
        assertEquals('N', priorityQueue.delMax().charValue());
        assertEquals('K', priorityQueue.delMax().charValue());
        assertEquals('A', priorityQueue.delMax().charValue());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(7, priorityQueue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.delMax();
        assertTrue(priorityQueue.isEmpty());
    }
}
