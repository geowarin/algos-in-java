package com.algos.structure.symboltable;

import com.algos.structure.simple.TableIterator;
import com.algos.structure.tree.priorityqueue.Queues;

/**
 * User: sennen
 * Date: 05/04/2014
 * Time: 12:19
 */
public class BinarySearchSymbolTable<X extends Comparable<X>, Y> implements ComparableSymbolTable<X, Y> {
    private final TableSupplier<X> keysTableSupplier;
    private final TableSupplier<Y> valuesTableSupplier;
    private X[] keys;
    private Y[] values;
    private int size = 0;

    public BinarySearchSymbolTable(TableSupplier<X> keysTableSupplier, TableSupplier<Y> valuesTableSupplier) {
        this.keysTableSupplier = keysTableSupplier;
        this.valuesTableSupplier = valuesTableSupplier;
    }

    @Override
    public void put(X key, Y value) {
        int keyIndex = rank(key);
        if (keyIndex >= size || !keys[keyIndex].equals(key)) {
            size++;
            adjustSpace(keyIndex);
            keys[keyIndex] = key;
        }
        values[keyIndex] = value;
    }

    @Override
    public Y get(X key) {
        int keyIndex = rank(key);
        if (keyIndex >= size || !keys[keyIndex].equals(key)) {
            return null;
        }
        return values[keyIndex];
    }

    @Override
    public X min() {
        return keys[0];
    }

    @Override
    public X max() {
        return keys[size - 1];
    }

    @Override
    public X floor(X key) {
        int rank = rank(key);
        if (rank == size) {
            return keys[size - 1];
        }
        return keys[rank].equals(key) ? keys[rank] : keys[rank - 1];
    }

    @Override
    public X ceiling(X key) {
        int rank = rank(key);
        if (rank == size) {
            return keys[size - 1];
        }
        return keys[rank];
    }

    @Override
    public int rank(X key) {
        return rank(key, 0, size - 1);
    }

    @Override
    public X select(int k) {
        return keys[k];
    }

    @Override
    public int size(X lo, X hi) {
        return Math.abs(rank(hi) - rank(lo)) + 1;
    }

    @Override
    public void delete(X key) {
        if(!contains(key)) {
            return;
        }
        int keyRank = rank(key);
        for (int i = keyRank; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<X> keys(X lo, X hi) {
        int loRank = rank(lo);
        int hiRank = rank(hi);
        return () -> new TableIterator<>(keys, Math.min(loRank, hiRank), Math.max(loRank, hiRank));
    }

    private int rank(X key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int comparison = key.compareTo(keys[mid]);
        if (comparison < 0) {
            return rank(key, lo, mid - 1);
        } else if (comparison > 0) {
            return rank(key, mid + 1, hi);
        }
        return mid;
    }

    private void adjustSpace(int keyIndex) {
        keys = Queues.adjustSpaceIfNeeded(keys, keysTableSupplier, size);
        values = Queues.adjustSpaceIfNeeded(values, valuesTableSupplier, size);
        for (int i = size - 1; i > keyIndex; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
    }

}
