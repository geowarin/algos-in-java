package com.algos.structure.symboltable;

/**
 * @author Sennen
 * @since 22/10/13 20:49
 */
public abstract class HashSymbolTable<X,Y> implements SymbolTable<X, Y> {
    protected int hashSize;

    public HashSymbolTable(int hashSize) {
        this.hashSize = hashSize;
    }

    protected int hash(X key) {
        return (key.hashCode() & 0x7fffffff) % hashSize;
    }
}
