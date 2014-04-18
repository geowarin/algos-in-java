package com.algos.structure.symboltable;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * User: sennen
 * Date: 05/04/2014
 * Time: 12:34
 */
public class BinarySearchSymbolTableTest {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchSymbolTableTest.class);
    private BinarySearchSymbolTable<String, Integer> symbolTable;

    @Before
    public void setUp() throws Exception {
        symbolTable = getSymbolTable();
        FrequencyCounterUtil.loadSymbolTable(symbolTable, "tinyTale.txt", 0);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", getSymbolTable().isEmpty());
    }

    @Test
    public void testTinySearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tinyTale.txt", getSymbolTable(), logger);
        assertEquals("it", maxFrequency.getKey());
        assertEquals(10, maxFrequency.getValue().intValue());
    }

    @Test(timeout = 5000)
    public void testMediumSearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tale.txt", getSymbolTable(), 8, logger);
        assertEquals("business", maxFrequency.getKey());
        assertEquals(122, maxFrequency.getValue().intValue());
    }

    private BinarySearchSymbolTable<String, Integer> getSymbolTable() {
        return new BinarySearchSymbolTable<>(String[]::new, Integer[]::new);
    }

    @Test
    public void testMin() throws Exception {
        assertEquals("age", symbolTable.min());
    }

    @Test
    public void testMax() throws Exception {
        assertEquals("worst", symbolTable.max());
    }

    @Test
    public void testFloor() throws Exception {
        assertEquals("it", symbolTable.floor("it"));
        assertEquals("best", symbolTable.floor("business"));
        assertEquals("worst", symbolTable.floor("wrong"));
    }

    @Test
    public void testCeiling() throws Exception {
        assertEquals("it", symbolTable.ceiling("it"));
        assertEquals("darkness", symbolTable.ceiling("business"));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(20, symbolTable.size());
        assertFalse(symbolTable.contains("business"));
        symbolTable.delete("business");
        assertEquals(20, symbolTable.size());
        assertTrue(symbolTable.contains("it"));
        symbolTable.delete("it");
        assertFalse(symbolTable.contains("it"));
        assertEquals(19, symbolTable.size());
    }

    @Test
    public void testDeleteMin() throws Exception {
        assertEquals("age", symbolTable.min());
        assertEquals(20, symbolTable.size());
        symbolTable.deleteMin();
        assertEquals(19, symbolTable.size());
        assertFalse(symbolTable.contains("age"));
    }

    @Test
    public void testDeleteMax() throws Exception {
        assertEquals("worst", symbolTable.max());
        assertEquals(20, symbolTable.size());
        symbolTable.deleteMax();
        assertEquals(19, symbolTable.size());
        assertFalse(symbolTable.contains("worst"));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(20, symbolTable.size());
        assertEquals(20, symbolTable.size("age", "worst"));
        assertEquals(1, symbolTable.size("worst", "worst"));
    }

    @Test
    public void testSelect() throws Exception {
        assertEquals("age", symbolTable.select(0));
        assertEquals("worst", symbolTable.select(19));
    }
}
