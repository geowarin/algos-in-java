package com.algos.sort;

/**
 * @author Sennen
 * @since 09/10/13 00:29
 */
public class QuickSorter<T extends Comparable<T>> extends AbstractQuickSorter<T> {
    @Override
    protected boolean check(int loIndex, int hiIndex) {
        return loIndex >= hiIndex;
    }

    @Override
    protected void handleNoPartitionCase(int loIndex, int hiIndex) {
    }
}
