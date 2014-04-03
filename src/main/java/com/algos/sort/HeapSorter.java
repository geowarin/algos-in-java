package com.algos.sort;

import com.algos.structure.symboltable.TableSupplier;

import java.util.Arrays;

/**
 * User: sennen
 * Date: 01/04/2014
 * Time: 18:53
 * NlogN order sort algorithm. 1 extra space and in place sort.
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {
    private final TableSupplier<T> tableSupplier;

    public HeapSorter(TableSupplier<T> tableSupplier) {
        this.tableSupplier = tableSupplier;
    }

    @Override
    public T[] sort(T[] tableToSort) {
        int tableLength = tableToSort.length;
        tableToSort = addOneElementAndShiftToRight(tableToSort);
        buildHeap(tableToSort, tableLength);
        exchangeAndRepair(tableToSort, tableLength);
        return Arrays.copyOfRange(tableToSort, 1, tableLength + 1);
    }

    private T[] addOneElementAndShiftToRight(T[] tableToSort) {
        int tableLength = tableToSort.length;
        T[] shiftedTable = tableSupplier.get(tableLength + 1);
        System.arraycopy(tableToSort, 0, shiftedTable, 1, tableLength);
        return shiftedTable;
    }

    private void buildHeap(T[] tableToSort, int n) {
        for (int k = n / 2; k >= 1; k--) {
            SorterHelper.sink(tableToSort, k, n);
        }
    }

    private void exchangeAndRepair(T[] tableToSort, int n) {
        while (n >= 1) {
            SorterHelper.exchange(tableToSort, 1, n--);
            SorterHelper.sink(tableToSort, 1, n);
        }
    }
}
