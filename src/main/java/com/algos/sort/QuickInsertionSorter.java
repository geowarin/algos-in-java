package com.algos.sort;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 09/10/13 20:32
 * This algorithm combines insertion sort for its small part and quick sort for bigger part as insertion sort is
 * faster on small tables.
 */
public class QuickInsertionSorter<T extends Comparable<T>> extends AbstractQuickSorter<T> {

    public static final int TABLE_PART_SIZE_FOR_INSERTION_SORT = 3;

    @Override
    protected boolean check(int loIndex, int hiIndex) {
        return hiIndex - loIndex <= TABLE_PART_SIZE_FOR_INSERTION_SORT;
    }

    @Override
    protected void handleNoPartitionCase(int loIndex, int hiIndex) {
        if(loIndex >= hiIndex) {
            return;
        }
        int hiCopyLimit = hiIndex >= tableToSort.length ? tableToSort.length : hiIndex + 1;
        T[] copyFromLoToHiIndex = Arrays.copyOfRange(tableToSort, loIndex, hiCopyLimit);
        InsertionSorter<T> insertionSorter = new InsertionSorter<>();
        insertionSorter.sort(copyFromLoToHiIndex);
        copyAll(copyFromLoToHiIndex, loIndex);
    }

    private void copyAll(T[] copyFromLoToHiIndex, int loIndex) {
        int index = loIndex;
        for (T element : copyFromLoToHiIndex) {
            tableToSort[index] = element;
            index++;
        }
    }
}
