package com.algos.structure.simple;

import java.util.Iterator;

public class FixedCapacityStack<T> implements Stack<T> {

    private final Object[] stackEntries;
    private int size = 0;

    public FixedCapacityStack(int capacity) {
        stackEntries = new Object[capacity];
    }

    @Override
    public void push(T item) {
        stackEntries[size++] = item;
    }

    @Override
    public T pop() {
        return (T) stackEntries[--size];
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
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int position = FixedCapacityStack.this.size;

        @Override
        public boolean hasNext() {
            return position > 0;
        }

        @Override
        public T next() {
            return (T) stackEntries[--position];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(ReverseArrayIterator.class.getName() +
                                                    " doesn't support remove operation.");
        }
    }
}
