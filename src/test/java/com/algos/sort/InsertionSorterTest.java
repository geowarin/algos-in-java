package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sennen
 * @since 26/09/13 21:55
 */
public class InsertionSorterTest extends SorterTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSorterTest.class);

    @Test
    public void testSort() throws Exception {
        testSorter(new InsertionSorter<>(), LOGGER);
    }
}
