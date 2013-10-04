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
        mergeSortedParts(lowIndex, midIndex, hiIndex);
    }

    private void mergeSortedParts(int lowIndex, int midIndex, int hiIndex) {
        T[] copyOfMergingPart = Arrays.copyOfRange(tableToSort, lowIndex, hiIndex + 1);
        int midIndexInCopyTable = midIndex - lowIndex;
        int hiIndexInCopyTable = hiIndex - lowIndex;

        int firstMergingPartIndex = 0, secondMergingPartIndex = midIndexInCopyTable + 1;
        boolean firstPartOver = false, secondPartOver = false;
        for (int i = 0; i < copyOfMergingPart.length; i++) {
            if (firstPartOver) {
//                System.out.println("first part over : " + (hiIndexInCopyTable - secondMergingPartIndex + 1));
                copyAll(copyOfMergingPart, lowIndex + i, secondMergingPartIndex, hiIndexInCopyTable);
                break;
            } else if (secondPartOver) {
//                System.out.println("second part over : " + (midIndexInCopyTable - firstMergingPartIndex + 1));
                copyAll(copyOfMergingPart, lowIndex + i, firstMergingPartIndex, midIndexInCopyTable);
                break;
            }
            T currentElementOfFirstPart = copyOfMergingPart[firstMergingPartIndex];
            T currentElementOfSecondPart = copyOfMergingPart[secondMergingPartIndex];
            if (SorterHelper.lesser(currentElementOfFirstPart, currentElementOfSecondPart)) {
                tableToSort[lowIndex + i] = currentElementOfFirstPart;
                firstPartOver = firstMergingPartIndex++ >= midIndexInCopyTable;
            } else {
                tableToSort[lowIndex + i] = currentElementOfSecondPart;
                secondPartOver = secondMergingPartIndex++ >= hiIndexInCopyTable;
            }
        }
    }

    private void copyAll(T[] copyOfMergingPart, int from, int fromCopyIndex, int toCopyIndex) {
        int limit = from + toCopyIndex - fromCopyIndex;
        int index = from;
        while (index <= limit) {
            tableToSort[index++] = copyOfMergingPart[fromCopyIndex++];
        }
    }
}
