package com.algos.sort;

/**
 * @author  Sennen
 * @since   26/09/13 21:34
 */
public interface Sorter<T extends Comparable<T>> {
    public void sort(T[] tableToSort);
}
