package com.algos.structure.symboltable;

/**
 * @author Sennen
 * @since 23/12/13 03:49
 */
public interface Set<T> {
    void add(T element);

    void delete(T element);

    boolean contains(T element);

    boolean isEmpty();

    int size();
}
