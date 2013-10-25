package com.algos.structure.symboltable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class SequentialSearchSymbolTableTest {
    private static final Logger logger = LoggerFactory.getLogger(SequentialSearchSymbolTableTest.class);

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", new SequentialSearchSymbolTable<String,Integer>().isEmpty());
    }

    @Test
    public void testTinySearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tinyTale.txt", new SequentialSearchSymbolTable<>(), logger);
        assertEquals("of", maxFrequency.getKey());
        assertEquals(10, maxFrequency.getValue().intValue());
    }

    @Test(timeout = 5000)
    public void testMediumSearch() throws Exception {
        Map.Entry<String, Integer> maxFrequency =
                FrequencyCounterUtil.getMaxFrequencyCount("tale.txt", new SequentialSearchSymbolTable<>(), 8, logger);
        assertEquals("business", maxFrequency.getKey());
        assertEquals(122, maxFrequency.getValue().intValue());
    }
}