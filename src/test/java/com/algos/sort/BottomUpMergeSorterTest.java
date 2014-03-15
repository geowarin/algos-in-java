package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sennen
 * @since 04/10/13 01:41
 */
public class BottomUpMergeSorterTest extends SorterTestCase {
    private static final Logger logger = LoggerFactory.getLogger(BottomUpMergeSorterTest.class);

    @Test
    public void testSort() throws Exception {
        testSorter(new BottomUpMergeSorter<>(), logger);
    }
}
