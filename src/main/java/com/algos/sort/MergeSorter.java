package com.algos.sort;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 08/10/13 22:28
 */
public abstract class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    protected void mergeSortedParts(T[] tableToSort, int lowIndex, int midIndex, int hiIndex) {
        T[] copyOfMergingPart = Arrays.copyOfRange(tableToSort, lowIndex, hiIndex + 1);
        int midIndexInCopyTable = midIndex - lowIndex;
        int hiIndexInCopyTable = hiIndex - lowIndex;

        int firstMergingPartIndex = 0, secondMergingPartIndex = midIndexInCopyTable + 1;
        boolean firstPartOver = false, secondPartOver = false;
        for (int i = 0; i < copyOfMergingPart.length; i++) {
            if (firstPartOver) {
//                System.out.println("first part over : " + (hiIndexInCopyTable - secondMergingPartIndex + 1));
                copyAll(tableToSort, copyOfMergingPart, lowIndex + i, secondMergingPartIndex, hiIndexInCopyTable);
                break;
            } else if (secondPartOver) {
//                System.out.println("second part over : " + (midIndexInCopyTable - firstMergingPartIndex + 1));
                copyAll(tableToSort, copyOfMergingPart, lowIndex + i, firstMergingPartIndex, midIndexInCopyTable);
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

    private void copyAll(T[] tableToSort, T[] copyOfMergingPart, int from, int fromCopyIndex, int toCopyIndex) {
        int limit = from + toCopyIndex - fromCopyIndex;
        int index = from;
        while (index <= limit) {
            tableToSort[index++] = copyOfMergingPart[fromCopyIndex++];
        }
    }
}
