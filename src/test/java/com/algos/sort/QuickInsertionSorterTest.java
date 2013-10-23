package com.algos.sort;

import org.junit.Test;

/**
 * @author Sennen
 * @since 14/10/13 13:17
 */
public class QuickInsertionSorterTest extends SorterTestCase{
    @Test
    public void test() throws Exception {
        testSorter(new QuickInsertionSorter<>());
    }
}
