package com.algos.sort;

import org.junit.Test;

/**
 * @author Sennen
 * @since 09/10/13 01:12
 */
public class QuickSorterTest extends SorterTestCase {
    @Test
    public void test() throws Exception {
        testSorter(new QuickSorter<>());
    }
}
