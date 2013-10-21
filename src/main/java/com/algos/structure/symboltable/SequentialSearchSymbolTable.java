package com.algos.structure.symboltable;

import com.algos.structure.Node;

import java.util.Iterator;

public class SequentialSearchSymbolTable<X, Y> implements SymbolTable<X, Y> {
    private Node<SymbolTableEntry<X, Y>> first;
    private int size = 0;

    @Override
    public void put(X key, Y value) {
        for (Node<SymbolTableEntry<X, Y>> node = first; node != null; node = node.next()) {
            if (key.equals(node.getValue().getKey())) {
                node.getValue().setValue(value);
                return;
            }
        }
        Node<SymbolTableEntry<X, Y>> newFirst =
                new Node<SymbolTableEntry<X, Y>>(new SymbolTableEntryImpl<>(key, value));
        newFirst.setNext(first);
        first = newFirst;
        size++;
    }

    @Override
    public Y get(X key) {
        for (Node<SymbolTableEntry<X, Y>> node = first; node != null; node = node.next()) {
            if (key.equals(node.getValue().getKey())) {
                return node.getValue().getValue();
            }
        }
        return null;
    }

    @Override
    public void delete(X key) {
        // Eager deletion easier to handle with linked list
        Node<SymbolTableEntry<X, Y>> previousNode = null;
        for (Node<SymbolTableEntry<X, Y>> node = first; node != null; node = node.next()) {
            if (key.equals(node.getValue().getKey())) {
                if (previousNode == null) {
                    this.first = first.next();
                } else {
                    previousNode.setNext(node.next());
                }
                size--;
            }
            previousNode = node;
        }
    }

    @Override
    public boolean contains(X key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<X> keys() {
        return new Iterable<X>() {
            @Override
            public Iterator<X> iterator() {
                return new Iterator<X>() {
                    private Node<SymbolTableEntry<X, Y>> node = first;
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < size;
                    }

                    @Override
                    public X next() {
                        index++;
                        Node<SymbolTableEntry<X, Y>> node = this.node;
                        this.node = this.node.next();
                        return node.getValue().getKey();
                    }
                };
            }
        };
    }
}
