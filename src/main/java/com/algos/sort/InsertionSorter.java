package com.algos.sort;

/**
 * @author Sennen
 * @since 26/09/13
 * This is the sorting algorithm to choose when number of inversions are low in the table to sort.
 */

import static com.algos.sort.SorterHelper.lesser;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {
    private T[] tableToSort;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = tableToSort;
        for (int position = 0; position < tableToSort.length; position++) {
            shiftLeftEveryElementLesserThanPreviousFrom(position);
        }
    }

    private void shiftLeftEveryElementLesserThanPreviousFrom(int index) {
        for (int currentIndex = index;
             currentIndex > 0 && lesser(tableToSort[currentIndex], tableToSort[currentIndex - 1]);
             currentIndex--) {
            shiftLeftElement(currentIndex);
        }
    }

    private void shiftLeftElement(int currentIndex) {
        T element = tableToSort[currentIndex];
        tableToSort[currentIndex] = tableToSort[currentIndex - 1];
        tableToSort[currentIndex - 1] = element;
    }
}
