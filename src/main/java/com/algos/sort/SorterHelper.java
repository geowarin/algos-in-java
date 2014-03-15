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

    static <T extends Comparable<T>> boolean greater(T elementSupposedToBeLesser, T elementSupposedToBeGreater) {
        return Ordering.natural().compare(elementSupposedToBeGreater, elementSupposedToBeLesser) < 0;
    }

    public static <T> void exchange(T[] tableToSort, int index, int index1) {
        if (index == index1) {
            return;
        }
        T tempElement = tableToSort[index1];
        tableToSort[index1] = tableToSort[index];
        tableToSort[index] = tempElement;
    }
}
