package com.algos.structure.simple;

/**
 * @author Sennen
 * @since 29/12/13 22:13
 */

import java.util.Iterator;

public class LinkedListBag<T> implements Bag<T> {
    private Node<T> first;
    private int size = 0;

    @Override
    public void add(T item) {
        Node<T> oldFirst = first;
        first = new Node<>(item);
        first.setNext(oldFirst);
        size++;
    }

    @Override
    public boolean contains(T item) {
        for (Node<T> currentNode = first; currentNode != null; currentNode = currentNode.next()) {
            if (currentNode.getValue().equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T value = currentNode.getValue();
                currentNode = currentNode.next();
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not relevant for this implementation!");
            }
        };
    }
}

