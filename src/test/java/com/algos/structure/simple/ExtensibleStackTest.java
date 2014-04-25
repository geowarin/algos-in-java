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

public class ExtensibleStackTest {
    private static final List<String> EXPECTED_FIRST_NAMES =
            Arrays.asList("Sennen", "Nini", "Maguette", "Keyo", "Chris", "Jo", "Estelle", "Khyan", "Eli", "Loulette",
                          "Jeanine");

    private ExtensibleStack<String> firstNamesStack;

    @Before
    public void setUp() {
        firstNamesStack = new ExtensibleStack<>();
        for (String expectedFirstName : EXPECTED_FIRST_NAMES) {
            firstNamesStack.push(expectedFirstName);
        }
    }

    @Test
    public void testPushPop() throws Exception {
        List<String> actualFirstNames = new ArrayList<>();
        while (!firstNamesStack.isEmpty()) {
            actualFirstNames.add(firstNamesStack.pop());
        }
        assertNull(firstNamesStack.pop());
        assertEquals(0, firstNamesStack.size());
        firstNamesStack.push("Sennen");
        assertEquals("Sennen", firstNamesStack.pop());
        int initialPosition = EXPECTED_FIRST_NAMES.size() - 1, position = initialPosition;
        for (String actualFirstName : actualFirstNames) {
            assertEquals(actualFirstName, EXPECTED_FIRST_NAMES.get(position));
            position--;
        }
        assertEquals(EXPECTED_FIRST_NAMES.size(), Math.abs(position - initialPosition));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<String> firstNamesStackIterator = firstNamesStack.iterator();
        int initialPosition = EXPECTED_FIRST_NAMES.size() - 1, position = initialPosition;
        while (firstNamesStackIterator.hasNext()) {
            assertEquals(EXPECTED_FIRST_NAMES.get(position), firstNamesStackIterator.next());
            position--;
        }
        assertEquals(EXPECTED_FIRST_NAMES.size(), Math.abs(position - initialPosition));
        assertNull(firstNamesStackIterator.next());

        final Iterator<String> firstNamesStackIteratorForRemoveTest = firstNamesStack.iterator();
        firstNamesStackIteratorForRemoveTest.remove();
        assertFails(firstNamesStackIteratorForRemoveTest::remove, IllegalStateException.class,
                    "You must call next() before trying to remove again!");
        assertNull(firstNamesStackIteratorForRemoveTest.next());
    }
}
