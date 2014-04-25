package com.algos.structure.simple;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> currentNode;
    private Node<T> lastNode;
    private int size = 0;

    @Override
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if(lastNode != null) {
            lastNode.setNext(node);
        }
        if(currentNode == null) {
            currentNode = node;
        }
        lastNode = node;
        size++;
    }

    @Override
    public T dequeue() {
        T valueToDequeue = currentNode.getValue();
        currentNode = currentNode.next();
        size--;
        return valueToDequeue;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = LinkedListQueue.this.currentNode;
            private int size = LinkedListQueue.this.size;

            @Override
            public boolean hasNext() {
                return size >= 1;
            }

            @Override
            public T next() {
                T nextValue = currentNode.getValue();
                currentNode = currentNode.next();
                size--;
                return nextValue;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported!");
            }
        };
    }
}
