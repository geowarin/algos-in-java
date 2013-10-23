package com.algos.sort;

import org.junit.Test;

/**
 * @author Sennen
 * @since 04/10/13 01:41
 */
public class BottomUpMergeSorterTest extends SorterTestCase {
    @Test
    public void testSort() throws Exception {
        testSorter(new BottomUpMergeSorter<>());
    }
}
