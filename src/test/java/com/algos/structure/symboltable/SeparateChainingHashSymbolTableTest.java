package com.algos.structure.symboltable;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.*;
import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Sennen
 * @since 21/10/13 01:00
 */
public class SeparateChainingHashSymbolTableTest {

    public static final String CHRISTOPHE = "CHRISTOPHE";
    public static final String SENNEN = "SENNEN";
    public static final String NINI = "NINI";
    public static final String FATOU = "FATOU";
    public static final String KEYO = "KEYO";
    public static final String JO = "JO";
    private SeparateChainingHashSymbolTable<String, Integer> nameToAgeHashSymbolTable;

    @Before
    public void setUp() {
        nameToAgeHashSymbolTable = new SeparateChainingHashSymbolTable<>();
        nameToAgeHashSymbolTable.put(SENNEN, 26);
        nameToAgeHashSymbolTable.put(NINI, 26);
        nameToAgeHashSymbolTable.put(CHRISTOPHE, 32);
        nameToAgeHashSymbolTable.put(FATOU, 25);
        nameToAgeHashSymbolTable.put(KEYO, 22);
        nameToAgeHashSymbolTable.put(JO, 20);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", new SeparateChainingHashSymbolTable<String,Integer>().isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(6, nameToAgeHashSymbolTable.size());
        nameToAgeHashSymbolTable.delete(CHRISTOPHE);
        assertEquals(5, nameToAgeHashSymbolTable.size());
    }

    @Test
    public void testGet() throws Exception {
        assertThat(nameToAgeHashSymbolTable.get(CHRISTOPHE)).isEqualTo(32);
    }

    @Test
    public void testDelete() throws Exception {
        assertThat(nameToAgeHashSymbolTable.get(CHRISTOPHE)).isEqualTo(32);
        nameToAgeHashSymbolTable.delete(CHRISTOPHE);
        assertThat(nameToAgeHashSymbolTable.get(CHRISTOPHE)).isNull();
    }

    @Test
    public void testIterator() throws Exception {
        assertThatIterator(nameToAgeHashSymbolTable.keys().iterator())
                .nextEquals(SENNEN)
                .nextEquals(NINI)
                .nextEquals(CHRISTOPHE)
                .nextEquals(FATOU)
                .nextEquals(KEYO)
                .nextEquals(JO)
                .hasNoNext();
    }

    @Test
    public void testTinySearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tinyTale.txt", SeparateChainingHashSymbolTable::new);
        assertEquals("it", maxFrequency.getKey());
        assertEquals(10, maxFrequency.getValue().intValue());
    }

    @Test(timeout = 5000)
    public void testMediumSearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tale.txt", SeparateChainingHashSymbolTable::new, 8);
        assertEquals("business", maxFrequency.getKey());
        assertEquals(122, maxFrequency.getValue().intValue());
    }

    private static <T> IteratorAssert<T> assertThatIterator(Iterator<T> actualIterator) {
        return new IteratorAssert<>(actualIterator);
    }

    private static class IteratorAssert<T> {
        private Iterator<T> actualIterator;

        private IteratorAssert(Iterator<T> actualIterator) {
            this.actualIterator = actualIterator;
        }

        private IteratorAssert<T> nextEquals(T next) {
            hasNext();
            assertThat(next).isEqualTo(actualIterator.next());
            return this;
        }

        private IteratorAssert<T> hasNext() {
            assertTrue("Iterator should have next item", actualIterator.hasNext());
            return this;
        }

        private IteratorAssert<T> hasNoNext() {
            assertFalse("Iterator should not have next item", actualIterator.hasNext());
            return this;
        }
    }
}
