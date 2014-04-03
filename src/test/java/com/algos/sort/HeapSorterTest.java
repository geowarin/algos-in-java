package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: sennen
 * Date: 01/04/2014
 * Time: 18:53
 */
public class HeapSorterTest extends SorterTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeapSorterTest.class);

    @Test
    public void testSort() throws Exception {
        testSorter(new HeapSorter<>(Character[]::new), LOGGER);
    }
}
