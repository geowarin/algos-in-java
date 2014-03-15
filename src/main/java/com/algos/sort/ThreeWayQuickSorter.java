package com.algos.sort;

/**
 * User: sennen
 * Date: 11/03/2014
 * Time: 13:46
 */
public class ThreeWayQuickSorter<T extends Comparable<T>> implements Sorter<T> {

    private T[] tableToSort;

    @Override
    public void sort(T[] tableToSort) {
        this.tableToSort = tableToSort;
        sort(0, tableToSort.length -1);
    }

    private void sort(int lowIndex, int highIndex) {
        if(highIndex<=lowIndex) {
            return;
        }
        int lowTracker = lowIndex;
        int tracker = lowIndex + 1;
        int highTracker = highIndex;
        T partitionKey = tableToSort[lowIndex];
        while(tracker <= highTracker) {
            T trackedElement = tableToSort[tracker];
            if (SorterHelper.lesser(trackedElement, partitionKey)) {
                SorterHelper.exchange(tableToSort, lowTracker++, tracker++);
            } else if (SorterHelper.greater(trackedElement, partitionKey)) {
                SorterHelper.exchange(tableToSort, tracker, highTracker--);
            } else {
                tracker++;
            }
        }
        sort(lowIndex, lowTracker - 1);
        sort(highTracker + 1, highIndex);
    }
}
