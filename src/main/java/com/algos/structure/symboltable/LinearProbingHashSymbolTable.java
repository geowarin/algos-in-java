package com.algos.structure.symboltable;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Sennen
 * @since 22/10/13 20:38
 */
public class LinearProbingHashSymbolTable<X, Y> extends HashSymbolTable<X, Y> {
    private final TableSupplier<X> keysTableSupplier;
    private final TableSupplier<Y> valuesTableSupplier;
    private int numberOfPairsInTable;
    private X[] keys;
    private Y[] values;

    public LinearProbingHashSymbolTable(TableSupplier<X> keysTableSupplier, TableSupplier<Y> valuesTableSupplier) {
        this(16, keysTableSupplier, valuesTableSupplier);
    }

    public LinearProbingHashSymbolTable(int sizeOfLinearProbing, TableSupplier<X> keysTableSupplier,
                                        TableSupplier<Y> valuesTableSupplier) {
        super(sizeOfLinearProbing);
        this.keysTableSupplier = keysTableSupplier;
        this.valuesTableSupplier = valuesTableSupplier;
        keys = keysTableSupplier.get(sizeOfLinearProbing);
        values = valuesTableSupplier.get(sizeOfLinearProbing);
    }

    @Override
    public void put(X key, Y value) {
        resizeIfNecessary(() -> numberOfPairsInTable >= hashSize / 2, 2 * hashSize);
        int keyIndex = getIndex(key);
        if (keys[keyIndex] == null) {
            keys[keyIndex] = key;
            numberOfPairsInTable++;
        }
        values[keyIndex] = value;
    }

    @Override
    public Y get(X key) {
        return values[getIndex(key)];
    }

    @Override
    public void delete(X key) {
        int keyIndex = getIndex(key);
        if (keys[keyIndex] != null) {
            keys[keyIndex] = null;
            values[keyIndex] = null;
            numberOfPairsInTable--;
            for (int i = keyIndex + 1; keys[i] != null; i = (i + 1) % hashSize) {
                numberOfPairsInTable--;
                X keyToPut = keys[i];
                Y valueToPut = values[i];
                keys[i] = null;
                values[i] = null;
                put(keyToPut, valueToPut);
            }
            resizeIfNecessary(() -> numberOfPairsInTable > 0 && numberOfPairsInTable <= hashSize / 8, hashSize / 2);
        }
    }

    @Override
    public boolean contains(X key) {
        int keyIndex = getIndex(key);
        return key.equals(keys[keyIndex]);
    }

    @Override
    public boolean isEmpty() {
        return numberOfPairsInTable == 0;
    }

    @Override
    public int size() {
        return numberOfPairsInTable;
    }

    @Override
    public Iterable<X> keys() {
        Stream<X> notNullKeysStream = Arrays.stream(keys).filter((key) -> key != null);
        return notNullKeysStream::iterator;
    }

    private int getIndex(X key) {
        int index = hash(key);
        for (; keys[index] != null; index = (index + 1) % hashSize) {
            if (key.equals(keys[index])) {
                break;
            }
        }
        return index;
    }

    private void resizeIfNecessary(SimplePredicate predicate, int newCapacity) {
        if (predicate.test()) {
            readjustTable(newCapacity);
        }
    }

    private void readjustTable(int newCapacity) {
        hashSize = newCapacity;
        numberOfPairsInTable = 0;
        X[] oldKeys = this.keys;
        Y[] oldValues = this.values;
        this.keys = keysTableSupplier.get(newCapacity);
        this.values = valuesTableSupplier.get(newCapacity);
        for (int i = 0; i < oldKeys.length; i++) {
            X key = oldKeys[i];
            if (key != null) {
                put(key, oldValues[i]);
            }
        }
    }
}
