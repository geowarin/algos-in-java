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
 * @since 25/10/13 01:32
 */
public class LinearProbingHashSymbolTableTest extends SymbolTableTestCase {
    private static final Logger logger = LoggerFactory.getLogger(LinearProbingHashSymbolTableTest.class);

    @Before
    public void setUp() {
        super.setUp(getSymbolTable());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", getSymbolTable().isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(6, nameToAgeHashSymbolTable.size());
        nameToAgeHashSymbolTable.delete(CHRISTOPHE);
        assertEquals(5, nameToAgeHashSymbolTable.size());
        nameToAgeHashSymbolTable.delete("ANYTHING");
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
                .nextEquals(KEYO)
                .nextEquals(JO)
                .nextEquals(NINI)
                .nextEquals(SENNEN)
                .nextEquals(CHRISTOPHE)
                .nextEquals(FATOU)
                .hasNoNext();
    }

    @Test
    public void testTinySearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tinyTale.txt", getSymbolTable(), logger);
        assertEquals("of", maxFrequency.getKey());
        assertEquals(10, maxFrequency.getValue().intValue());
    }

    @Test(timeout = 5000)
    public void testMediumSearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tale.txt", getSymbolTable(), 8, logger);
        assertEquals("business", maxFrequency.getKey());
        assertEquals(122, maxFrequency.getValue().intValue());
    }

    private LinearProbingHashSymbolTable<String, Integer> getSymbolTable() {
        return new LinearProbingHashSymbolTable<>((TableSupplier<String>) String[]::new,
                                                  (TableSupplier<Integer>) Integer[]::new);
    }
}
