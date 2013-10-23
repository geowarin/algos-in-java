package com.algos.sort;

/**
 * @author Sennen
 * @since 27/09/13 01:34
 */
public class TopDownMergeSorter<T extends Comparable<T>> extends MergeSorter<T> {

    private T[] tableToSort;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = tableToSort;
        merge(0, tableToSort.length - 1);
    }

    private void merge(int lowIndex, int hiIndex) {
        if (lowIndex == hiIndex) {
            return;
        }
        int midIndex = lowIndex + ((hiIndex - lowIndex) / 2);
        merge(lowIndex, midIndex);
        merge(midIndex + 1, hiIndex);
        mergeSortedParts(tableToSort, lowIndex, midIndex, hiIndex);
    }
}
