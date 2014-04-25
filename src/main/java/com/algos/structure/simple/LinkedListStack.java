package com.algos.structure.simple;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> currentNode;
    private int size = 0;

    @Override
    public void push(T item) {
        Node<T> node = new Node<>(item);
        if (currentNode != null) {
            node.setNext(currentNode);
        }
        currentNode = node;
        size++;
    }

    @Override
    public T pop() {
        T valueToPop = currentNode.getValue();
        currentNode = currentNode.next();
        size--;
        return valueToPop;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = LinkedListStack.this.currentNode;
            private int size = LinkedListStack.this.size;

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
