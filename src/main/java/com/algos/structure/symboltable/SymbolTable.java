package com.algos.structure.symboltable;

public interface SymbolTable<X,Y> {
    void put(X key, Y value);

    Y get(X key);

    void delete(X key);

    boolean contains(X key);

    boolean isEmpty();

    int size();

    Iterable<X> keys();
}
