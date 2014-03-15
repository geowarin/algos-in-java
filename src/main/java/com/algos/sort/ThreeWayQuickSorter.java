package com.algos.sort;

/**
 * User: sennen
 * Date: 11/03/2014
 * Time: 13:46
 */
public class ThreeWayQuickSorter<T extends Comparable<T>> implements Sorter<T> {

    // TODO The same than quick sort
    // single left to right pass through with 3 pointers,
    // lt such that a[lo..lt-1] is less than v,
    // i such that a[lt..i-1] are equal to v,
    // gt such that a[gt+1..hi] is greater than v. a[i..gt] are not yet examined.
    // Starting with i=lo, we process a[i] using the 3-way comparison given by Comparable :
    // a[i] less than v: exchange a[lt] with a[i] and increment both lt and i.
    // a[i] greater than v: exchange a[gt] with a[i], and decrement gt.
    // a[i] equal to v: increment i
    @Override
    public void sort(T[] tableToSort) {

    }
}
