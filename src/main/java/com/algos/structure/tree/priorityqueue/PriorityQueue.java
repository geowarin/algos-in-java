package com.algos.structure.tree.priorityqueue;

/**
 * User: sennen
 * Date: 16/03/2014
 * Time: 15:58
 */
public interface PriorityQueue<T extends Comparable<T>> {
    void offer(T item);

    T peek();

    T poll();

    int size();

    boolean isEmpty();
}
