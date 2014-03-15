package com.algos.sort;

import com.google.common.collect.Ordering;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 26/09/13 22:10
 */
public class SorterHelper {
  static <T extends Comparable<T>> boolean lesser(T elementSupposedToBeGreater, T elementSupposedToBeLesser) {
    return Ordering.natural().compare(elementSupposedToBeGreater, elementSupposedToBeLesser) < 0;
  }

    protected static <T extends Comparable<T>> void mergeSortedParts(T[] tableToSort, int lowIndex, int midIndex, int hiIndex) {
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
            if (lesser(currentElementOfFirstPart, currentElementOfSecondPart)) {
                tableToSort[lowIndex + i] = currentElementOfFirstPart;
                firstPartOver = firstMergingPartIndex++ >= midIndexInCopyTable;
            } else {
                tableToSort[lowIndex + i] = currentElementOfSecondPart;
                secondPartOver = secondMergingPartIndex++ >= hiIndexInCopyTable;
            }
        }
    }

    private static <T extends Comparable<T>> void copyAll(T[] tableToSort, T[] copyOfMergingPart,
                                                          int from, int fromCopyIndex, int toCopyIndex) {
        int limit = from + toCopyIndex - fromCopyIndex;
        int index = from;
        while (index <= limit) {
            tableToSort[index++] = copyOfMergingPart[fromCopyIndex++];
        }
    }
}
