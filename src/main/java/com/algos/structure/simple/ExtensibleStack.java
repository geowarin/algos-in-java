package com.algos.structure.simple;

import java.util.Arrays;
import java.util.Iterator;

public class ExtensibleStack<T> implements Stack<T> {
    private Object[] elements;
    private int size = 0;

    @Override
    public void push(T item) {
        elements = getElements();
        elements[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        elements = getElements();
        T itemToPop = (T) elements[--size];
        elements[size] = null;
        return itemToPop;
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
            private int currentPosition = size;
            private boolean deletionAllowed = true;
            private Object[] elements =
                    ExtensibleStack.this.elements == null ? new Object[0] :
                    Arrays.copyOf(ExtensibleStack.this.elements, ExtensibleStack.this.size);

            public boolean hasNext() {
                return currentPosition > 0;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    deletionAllowed = true;
                    return (T) elements[--currentPosition];
                }
                return null;
            }

            @Override
            public void remove() {
                if(!deletionAllowed) {
                    throw new IllegalStateException("You must call next() before trying to remove again!");
                }
                if (currentPosition <= size && currentPosition >= 0) {
                    deletionAllowed = false;
                    elements[currentPosition - 1] = null;
                }
            }
        };
    }

    private Object[] getElements() {
        if (elements == null || elements.length == 0) {
            return new Object[10];
        }
        if (elements[elements.length - 1] != null) {
            return Arrays.copyOf(elements, size + 10);
        }

        if (elements.length > 10 && elements[elements.length - 10] == null) {
            return Arrays.copyOf(elements, elements.length - 10);
        }
        return elements;
    }
}
