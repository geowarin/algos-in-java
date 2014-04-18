package com.algos.structure.symboltable;

public interface SymbolTable<X,Y> {
    void put(X key, Y value);

    Y get(X key);

    void delete(X key);

    default boolean contains(X key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    Iterable<X> keys();
}
