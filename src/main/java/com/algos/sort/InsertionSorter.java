package com.algos.sort;

/**
 * @author Sennen
 * @since 26/09/13
 * This is the sorting algorithm to choose when number of inversions are low in the table to sort.
 */

import static com.algos.sort.SorterHelper.lesser;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {
    public void sort(T[] tableToSort) {
        for (int i = 0; i < tableToSort.length; i++) {
            for (int j = i; j > 0 && lesser(tableToSort[j], tableToSort[j - 1]); j--) {
                T element = tableToSort[j];
                tableToSort[j] = tableToSort[j - 1];
                tableToSort[j - 1] = element;
            }
        }
    }
}
