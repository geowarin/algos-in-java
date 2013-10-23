package com.algos.sort;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sennen
 * @since 26/09/13 21:59
 */
public class SorterTestCase {

  private static final String BEGIN_SEPARATOR = "'";
  private static final String MIDDLE_SEPARATOR = "', ";
  private static final String END_SEPARATOR = "'";

  static void testSorter(Sorter<Character> sorter) {
    Character[] actualTable = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    sorter.sort(actualTable);
    print(actualTable);
    assertArrayEquals(
      new Character[]{'A', 'E', 'E', 'E', 'E', 'G', 'L', 'M', 'M', 'O', 'P', 'R', 'R', 'S', 'T', 'X'},
      actualTable);
  }

  private static <T> void print(T[] tableToPrint) {
    int size = tableToPrint.length;
    for (int i = 0; i < size - 1; i++) {
      T element = tableToPrint[i];
      System.out.print(BEGIN_SEPARATOR + element + MIDDLE_SEPARATOR);
    }
    System.out.println(BEGIN_SEPARATOR + tableToPrint[size - 1] + END_SEPARATOR);
  }
}
