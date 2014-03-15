package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: sennen
 * Date: 11/03/2014
 * Time: 13:46
 */
public class ThreeWayQuickSorterTest extends SorterTestCase {
    private static final Logger logger = LoggerFactory.getLogger(QuickInsertionSorterTest.class);

    @Test
    public void test() throws Exception {
        testSorter(new ThreeWayQuickSorter<>(), logger);
    }
}
