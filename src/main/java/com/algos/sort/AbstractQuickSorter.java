package com.algos.sort;

import java.util.Random;

/**
 * @author Sennen
 * @since 09/10/13 00:29
 */
public abstract class AbstractQuickSorter<T extends Comparable<T>> implements Sorter<T> {
    protected T[] tableToSort;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = shuffle(tableToSort);
        sort(0, tableToSort.length - 1);
    }

    protected abstract boolean check(int loIndex, int hiIndex);

    protected abstract void handleNoPartitionCase(int loIndex, int hiIndex);

    private T[] shuffle(T[] tableToSort) {
        Random rnd = new Random();
        for (int i = tableToSort.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            SorterHelper.exchange(tableToSort, index, i);
        }
        return tableToSort;
    }

    private void sort(int loIndex, int hiIndex) {
        if (check(loIndex, hiIndex)) {
            handleNoPartitionCase(loIndex, hiIndex);
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
                SorterHelper.exchange(tableToSort, leftScanIndex, rightScanIndex);
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
        SorterHelper.exchange(tableToSort, loIndex, rightScanIndex);

        return rightScanIndex;
    }
}
