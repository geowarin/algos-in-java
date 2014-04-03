package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopDownMergeSorterTest extends SorterTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopDownMergeSorterTest.class);

    @Test
    public void testSort() throws Exception {
        testSorter(new TopDownMergeSorter<>(), LOGGER);
    }
}
