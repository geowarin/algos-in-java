package com.algos.structure.symboltable;

/**
 * @author Sennen
 * @since 24/10/13 22:45
 */
@FunctionalInterface
public interface TableSupplier<T> {
    T[] get(int tableSize);
}
