package com.algos.sort;

/**
 * @author Sennen
 * @since 04/10/13 01:36
 */
public class BottomUpMergeSorter<T extends Comparable<T>> implements Sorter<T> {
    private T[] tableToSort;
    private int tableLength;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = tableToSort;
        tableLength = tableToSort.length;
        for (int mergeStep = 1; mergeStep <= tableLength / 2; mergeStep *= 2) {
            merge(mergeStep);
        }
    }

    private void merge(int mergeStep) {
        for (int i = 0; i < tableLength; i += (mergeStep * 2)) {
            int midIndex = i + mergeStep - 1 < tableLength ? i + mergeStep - 1 : tableLength;
            int hiIndex = i + mergeStep * 2 - 1 < tableLength ? i + mergeStep * 2 - 1 : tableLength;
            SorterHelper.mergeSortedParts(tableToSort, i, midIndex, hiIndex);
        }
    }
}
