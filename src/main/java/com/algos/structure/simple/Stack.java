package com.algos.structure.simple;

public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}
