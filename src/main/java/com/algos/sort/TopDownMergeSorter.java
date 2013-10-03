package com.algos.sort;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 27/09/13 01:34
 */
public class TopDownMergeSorter<T extends Comparable<T>> implements Sorter<T> {

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
        sortMerge(lowIndex, midIndex, hiIndex);
    }

    private void sortMerge(int lowIndex, int midIndex, int hiIndex) {
        T[] copyOfMergingPart = Arrays.copyOfRange(tableToSort, lowIndex, hiIndex + 1);
        int midIndexInCopyTable = midIndex - lowIndex;
        int hiIndexInCopyTable = hiIndex - lowIndex;

        int firstPartIndex = 0, secondPartIndex = midIndexInCopyTable + 1;
        boolean firstPartOver = false, secondPartOver = false;
        for (int i = 0; i < copyOfMergingPart.length; i++) {
            if (firstPartOver) {
//                System.out.println("first part over : " + (hiIndexInCopyTable - secondPartIndex + 1));
                copyAll(copyOfMergingPart, lowIndex + i, secondPartIndex, hiIndexInCopyTable);
                break;
            } else if (secondPartOver) {
//                System.out.println("second part over : " + (midIndexInCopyTable - firstPartIndex + 1));
                copyAll(copyOfMergingPart, lowIndex + i, firstPartIndex, midIndexInCopyTable);
                break;
            }
            T currentElementOfFirstPart = copyOfMergingPart[firstPartIndex];
            T currentElementOfSecondPart = copyOfMergingPart[secondPartIndex];
            if (SorterHelper.lesser(currentElementOfFirstPart, currentElementOfSecondPart)) {
                tableToSort[lowIndex + i] = currentElementOfFirstPart;
                firstPartOver = firstPartIndex++ >= midIndexInCopyTable;
            } else {
                tableToSort[lowIndex + i] = currentElementOfSecondPart;
                secondPartOver = secondPartIndex++ >= hiIndexInCopyTable;
            }
        }
    }

    private void copyAll(T[] copyOfMergingPart, int from, int lowIndex, int hiIndex) {
        int limit = from + hiIndex - lowIndex;
        int index = from;
        while (index <= limit) {
            tableToSort[index++] = copyOfMergingPart[lowIndex++];
        }
    }
}
