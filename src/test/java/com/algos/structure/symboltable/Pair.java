package com.algos.structure.symboltable;

import java.util.Map;

public class Pair<X,Y> implements Map.Entry<X,Y> {
    private final X key;
    private Y value;

    public Pair(X key, Y value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public X getKey() {
        return key;
    }

    @Override
    public Y getValue() {
        return value;
    }

    @Override
    public Y setValue(Y value) {
        this.value = value;
        return value;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
