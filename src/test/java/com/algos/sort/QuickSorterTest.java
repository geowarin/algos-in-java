package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sennen
 * @since 09/10/13 01:12
 */
public class QuickSorterTest extends SorterTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSorterTest.class);

    @Test
    public void test() throws Exception {
        testSorter(new QuickSorter<>(), LOGGER);
    }
}
