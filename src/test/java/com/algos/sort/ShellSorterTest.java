package com.algos.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sennen
 * @since 27/09/13 00:59
 */
public class ShellSorterTest extends SorterTestCase {
    private static final Logger logger = LoggerFactory.getLogger(ShellSorterTest.class);

    @Test
    public void test() throws Exception {
        testSorter(new ShellSorter<>(), logger);
    }
}
