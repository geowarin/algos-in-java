package com.algos.structure.simple;

/**
 * @author Sennen
 * @since 29/12/13 22:08
 */
public interface Bag<T> extends Iterable<T> {
    void add(T item);

    boolean contains(T item);

    boolean isEmpty();

    int size();
}
