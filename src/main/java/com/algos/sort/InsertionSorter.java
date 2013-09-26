package com.algos.sort;

/**
 * @author Sennen
 * @since 26/09/13
 * This is the sorting algorithm to choose when number of inversions are low in the table to sort.
 */

import static com.algos.sort.SorterHelper.lesser;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public void sort(T[] tableToSort) {
        for (int position = 0; position < tableToSort.length; position++) {
            shiftLeftEveryElementLesserThanPreviousFrom(position, tableToSort);
        }
    }

    private void shiftLeftEveryElementLesserThanPreviousFrom(int index, T[] tableToSort) {
        for (int currentIndex = index;
             currentIndex > 0 && lesser(tableToSort[currentIndex], tableToSort[currentIndex - 1]);
             currentIndex--) {
            shiftLeftElement(currentIndex, tableToSort);
        }
    }

    private void shiftLeftElement(int currentIndex, T[] tableToSort) {
        T element = tableToSort[currentIndex];
        tableToSort[currentIndex] = tableToSort[currentIndex - 1];
        tableToSort[currentIndex - 1] = element;
    }
}
