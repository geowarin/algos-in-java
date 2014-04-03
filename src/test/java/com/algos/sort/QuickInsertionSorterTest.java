package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sennen
 * @since 14/10/13 13:17
 */
public class QuickInsertionSorterTest extends SorterTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickInsertionSorterTest.class);

    @Test
    public void test() throws Exception {
        testSorter(new QuickInsertionSorter<>(), LOGGER);
    }
}
