package com.algos.structure.simple;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.algos.structure.tree.MaxPriorityQueue;
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
        priorityQueue.offer('A');
        priorityQueue.offer('O');
        priorityQueue.offer('T');
        priorityQueue.offer('S');
        priorityQueue.offer('N');
        priorityQueue.offer('R');
        priorityQueue.offer('P');
    }

    @Test
    public void testItemsAreOrdered() throws Exception {
        assertEquals('T', priorityQueue.peek().charValue());
        assertEquals('T', priorityQueue.poll().charValue());
        assertEquals('S', priorityQueue.poll().charValue());
        assertEquals('R', priorityQueue.poll().charValue());
        assertEquals('P', priorityQueue.poll().charValue());
        assertEquals('O', priorityQueue.poll().charValue());
        assertEquals('N', priorityQueue.poll().charValue());
        assertEquals('A', priorityQueue.poll().charValue());
    }

    @Test
    public void testItemsStillOrderedWithInsertionBetweenSeveralPolls() throws Exception {
        assertEquals('T', priorityQueue.peek().charValue());
        assertEquals('T', priorityQueue.poll().charValue());
        assertEquals('S', priorityQueue.poll().charValue());
        priorityQueue.offer('K');
        assertEquals('R', priorityQueue.poll().charValue());
        assertEquals('P', priorityQueue.poll().charValue());
        assertEquals('O', priorityQueue.poll().charValue());
        assertEquals('N', priorityQueue.poll().charValue());
        assertEquals('K', priorityQueue.poll().charValue());
        assertEquals('A', priorityQueue.poll().charValue());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(7, priorityQueue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertFalse(priorityQueue.isEmpty());
        priorityQueue.poll();
        assertTrue(priorityQueue.isEmpty());
    }
}
