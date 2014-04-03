package com.algos.structure.symboltable;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Sennen
 * @since 21/10/13 01:00
 */
public class SeparateChainingHashSymbolTableTest extends SymbolTableTestCase {
    private static final Logger logger = LoggerFactory.getLogger(SeparateChainingHashSymbolTableTest.class);

    @Before
    public void setUp() {
        super.setUp(new SeparateChainingHashSymbolTable<>());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", new SeparateChainingHashSymbolTable<String, Integer>().isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(6, nameToAgeHashSymbolTable.size());
        nameToAgeHashSymbolTable.delete(CHRISTOPHE);
        assertEquals(5, nameToAgeHashSymbolTable.size());
        nameToAgeHashSymbolTable.delete(ANYTHING);
        assertEquals(5, nameToAgeHashSymbolTable.size());
    }

    @Test
    public void testGet() throws Exception {
        assertThat(nameToAgeHashSymbolTable.get(CHRISTOPHE)).isEqualTo(32);
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(nameToAgeHashSymbolTable.contains(CHRISTOPHE));
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
                FrequencyCounterUtil.getMaxFrequencyCount("tinyTale.txt", new SeparateChainingHashSymbolTable<>(),
                                                          logger);
        assertEquals("it", maxFrequency.getKey());
        assertEquals(10, maxFrequency.getValue().intValue());
    }

    @Test(timeout = 5000)
    public void testMediumSearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tale.txt", new SeparateChainingHashSymbolTable<>(), 8, logger);
        assertEquals("business", maxFrequency.getKey());
        assertEquals(122, maxFrequency.getValue().intValue());
    }
}
