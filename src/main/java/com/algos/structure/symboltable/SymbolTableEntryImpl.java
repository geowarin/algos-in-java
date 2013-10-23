package com.algos.structure.symboltable;

public class SymbolTableEntryImpl<X, Y> implements SymbolTableEntry<X, Y> {
    private final X key;
    private Y value;

    public SymbolTableEntryImpl(X key, Y value) {
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
    public void setValue(Y value) {
        this.value = value;
    }
}
