package com.algos.sort;

import com.google.common.collect.Ordering;

/**
 * @author Sennen
 * @since 26/09/13 22:10
 */
public class SorterHelper {
  static <T extends Comparable<T>> boolean lesser(T elementSupposedToBeGreater, T elementSupposedToBeLesser) {
    return Ordering.natural().compare(elementSupposedToBeGreater, elementSupposedToBeLesser) < 0;
  }
}
