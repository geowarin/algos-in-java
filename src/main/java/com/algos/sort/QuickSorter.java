package com.algos.sort;

/**
 * @author Sennen
 * @since 09/10/13 00:29
 */
public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {
    private T[] tableToSort;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = tableToSort;
        sort(0, tableToSort.length - 1);
    }

    private void sort(int loIndex, int hiIndex) {
        if (loIndex >= hiIndex) {
            return;
        }
        int partitionItemIndex = partition(loIndex, hiIndex);
        sort(loIndex, partitionItemIndex - 1);
        sort(partitionItemIndex + 1, hiIndex);
    }

    private int partition(int loIndex, int hiIndex) {
        T partitioningItem = tableToSort[loIndex];
        int leftScanIndex = loIndex + 1, rightScanIndex = hiIndex;
        boolean leftScanStopped = false, rightScanStopped = false;

        while (leftScanIndex <= rightScanIndex) {
            if (leftScanStopped && rightScanStopped) {
                leftScanStopped = rightScanStopped = false;
                exchange(leftScanIndex, rightScanIndex);
                continue;
            }
            if (SorterHelper.lesser(tableToSort[rightScanIndex], partitioningItem)) {
                rightScanStopped = true;
            }
            if (SorterHelper.lesser(partitioningItem, tableToSort[leftScanIndex])) {
                leftScanStopped = true;
            }
            if (!leftScanStopped) {
                leftScanIndex++;
            }
            if (!rightScanStopped) {
                rightScanIndex--;
            }
        }
        exchange(loIndex, rightScanIndex);

        return rightScanIndex;
    }

    private void exchange(int i, int j) {
        T tempElement = tableToSort[j];
        tableToSort[j] = tableToSort[i];
        tableToSort[i] = tempElement;
    }
}
