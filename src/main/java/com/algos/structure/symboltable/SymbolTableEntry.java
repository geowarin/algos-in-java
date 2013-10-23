package com.algos.structure.symboltable;

public interface SymbolTableEntry<X, Y> {
    public X getKey();

    public Y getValue();

    public void setValue(Y value);
}
