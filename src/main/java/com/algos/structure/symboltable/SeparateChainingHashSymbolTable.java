package com.algos.structure.symboltable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Sennen
 * @since 21/10/13 00:46
 */
public class SeparateChainingHashSymbolTable<X, Y> implements SymbolTable<X, Y> {
    private final int hashSize;
    private int size;
    private final SequentialSearchSymbolTable<X, Y>[] symbolTables;
    private final Set<Integer> usedHashes = new LinkedHashSet<>();

    public SeparateChainingHashSymbolTable() {
        this(997);
    }

    public SeparateChainingHashSymbolTable(int hashSize) {
        this.hashSize = hashSize;
        symbolTables = (SequentialSearchSymbolTable<X, Y>[]) new SequentialSearchSymbolTable[hashSize];
        Arrays.setAll(symbolTables, value -> new SequentialSearchSymbolTable<X, Y>());
    }

    private int hash(X key) {
        return (key.hashCode() & 0x7fffffff) % hashSize;
    }

    @Override
    public void put(X key, Y value) {
        int hash = hash(key);
        SequentialSearchSymbolTable<X, Y> symbolTable = symbolTables[hash(key)];
        size += symbolTable.contains(key) ? 0 : 1;
        usedHashes.add(hash);
        symbolTable.put(key, value);
    }

    @Override
    public Y get(X key) {
        return symbolTables[hash(key)].get(key);
    }

    @Override
    public void delete(X key) {
        int hash = hash(key);
        SequentialSearchSymbolTable<X, Y> symbolTable = symbolTables[hash];
        size -= symbolTable.contains(key) ? 1 : 0;
        usedHashes.remove(hash);
        symbolTable.delete(key);
    }

    @Override
    public boolean contains(X key) {
        return symbolTables[hash(key)].contains(key);
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
    public Iterable<X> keys() {
        return () -> new Iterator<X>() {
            private int currentIndex;
            private Integer[] usedHashes =
                    SeparateChainingHashSymbolTable.this.usedHashes.toArray(
                            new Integer[SeparateChainingHashSymbolTable.this.usedHashes.size()]);
            private int usedHashesIndex;
            private Iterator<X> currentIterator;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public X next() {
                if (!hasNext()) {
                    return null;
                }

                if (currentIterator == null) {
                    currentIterator = symbolTables[usedHashes[usedHashesIndex]].keys().iterator();
                } else if (!currentIterator.hasNext() && usedHashesIndex < usedHashes.length) {
                    currentIterator = symbolTables[usedHashes[++usedHashesIndex]].keys().iterator();
                }

                if (currentIterator.hasNext()) {
                    currentIndex++;
                    return currentIterator.next();
                }
                return null;
            }
        };
    }
}
