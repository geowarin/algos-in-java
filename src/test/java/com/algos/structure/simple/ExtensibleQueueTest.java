package com.algos.structure.simple;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.algos.TestUtils.assertFails;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ExtensibleQueueTest {
    private static final List<String> EXPECTED_FIRST_NAMES =
            Arrays.asList("Sennen", "Nini", "Maguette", "Keyo", "Chris", "Jo", "Estelle", "Khyan", "Eli", "Loulette",
                          "Jeanine");

    private ExtensibleQueue<String> firstNamesQueue;

    @Before
    public void setUp() {
        firstNamesQueue = new ExtensibleQueue<>();
        for (String expectedFirstName : EXPECTED_FIRST_NAMES) {
            firstNamesQueue.enqueue(expectedFirstName);
        }
    }

    @Test
    public void testEnqueueDequeue() {
        ArrayList<String> actualFirstNames = new ArrayList<>();
        while (!firstNamesQueue.isEmpty()) {
            actualFirstNames.add(firstNamesQueue.dequeue());
        }
        assertNull(firstNamesQueue.dequeue());
        assertEquals(0, firstNamesQueue.size());
        firstNamesQueue.enqueue("Sennen");
        assertEquals("Sennen", firstNamesQueue.dequeue());
        int initialPosition = 0, position = initialPosition;
        for (String actualFirstName : actualFirstNames) {
            assertEquals(actualFirstName, EXPECTED_FIRST_NAMES.get(position));
            position++;
        }
        assertEquals(EXPECTED_FIRST_NAMES.size(), Math.abs(position - initialPosition));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<String> firstNamesQueueIterator = firstNamesQueue.iterator();
        int initialPosition = 0, position = initialPosition;
        while (firstNamesQueueIterator.hasNext()) {
            assertEquals(EXPECTED_FIRST_NAMES.get(position), firstNamesQueueIterator.next());
            position++;
        }
        assertEquals(EXPECTED_FIRST_NAMES.size(), Math.abs(position - initialPosition));
        assertNull(firstNamesQueueIterator.next());

        final Iterator<String> firstNamesQueueIteratorForRemoveTest = firstNamesQueue.iterator();
        firstNamesQueueIteratorForRemoveTest.remove();
        assertFails(firstNamesQueueIteratorForRemoveTest::remove, IllegalStateException.class,
                    "You must call next() before trying to remove again!");
        assertNull(firstNamesQueueIteratorForRemoveTest.next());
    }

}