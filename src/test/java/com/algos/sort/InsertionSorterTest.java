package com.algos.sort;

import org.junit.Test;

/**
 * @author Sennen
 * @since 26/09/13 21:55
 */
public class InsertionSorterTest extends SorterTestCase {
  @Test
  public void testSort() throws Exception {
    testSorter(new InsertionSorter<>());
  }
}
