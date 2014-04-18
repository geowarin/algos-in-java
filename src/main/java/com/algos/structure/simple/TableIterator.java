package com.algos.structure.simple;

import java.util.Arrays;
import java.util.Iterator;

/**
* User: sennen
* Date: 11/04/2014
* Time: 06:42
*/
public class TableIterator<X> implements Iterator<X> {
    private final int size;
    private final X[] keys;
    private int currentIndex = 0;

    public TableIterator(X[] keys, int loRank, int hiRank) {
        this.size = hiRank - loRank + 1;
        this.keys = Arrays.copyOfRange(keys, loRank, hiRank + 1);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public X next() {
        return keys[currentIndex++];
    }
}
