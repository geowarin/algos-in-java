package com.algos.structure.simple;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Exo 1.3.14
 */
public class ExtensibleQueue<T> implements Queue<T> {
    private Object[] elements;
    private int size = 0;

    @Override
    public void enqueue(T item) {
        elements = getElements();
        elements[size++] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        elements = getElements();
        size--;
        T itemToDequeue = (T) elements[0];
        int elementsLength = elements.length;
        elements = Arrays.copyOf(Arrays.copyOfRange(elements, 1, elementsLength), elementsLength);
        return itemToDequeue;
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
            private int currentPosition = -1;
            private boolean deletionAllowed = true;
            private Object[] elements =
                    ExtensibleQueue.this.elements == null ? new Object[0] :
                            Arrays.copyOf(ExtensibleQueue.this.elements, ExtensibleQueue.this.size);

            public boolean hasNext() {
                return currentPosition < elements.length - 1;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    deletionAllowed = true;
                    return (T) elements[++currentPosition];
                }
                return null;
            }

            @Override
            public void remove() {
                if(!deletionAllowed) {
                    throw new IllegalStateException("You must call next() before trying to remove again!");
                }
                if (currentPosition >= -1 && currentPosition < elements.length) {
                    deletionAllowed = false;
                    elements[currentPosition + 1] = null;
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
