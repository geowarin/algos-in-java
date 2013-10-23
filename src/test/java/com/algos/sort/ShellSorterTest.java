package com.algos.sort;

import org.junit.Test;

/**
 * @author Sennen
 * @since 27/09/13 00:59
 */
public class ShellSorterTest extends SorterTestCase {
  @Test
  public void test() throws Exception {
    testSorter(new ShellSorter<>());
  }
}
