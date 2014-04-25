package com.algos.structure.symboltable;

public interface ComparableSymbolTable<X extends Comparable<X>,Y> extends SymbolTable<X,Y> {
    X min();

    X max();

    /**
     * @param key Limit
     * @return Largest key that is less than or equal to the provided key
     */
    X floor(X key);

    /**
     * @param key Limit
     * @return Smallest key that is strictlyGreater than or equal to the provided key
     */
    X ceiling(X key);

    /**
     * @param key Key to rank
     * @return Number of keys strictlyLesser than the provided key
     */
    int rank(X key);

    /**
     * @param k Number of keys which are smaller than the key to return
     * @return A key for which <b>rank(select(key)) == k<b/>
     */
    X select(int k);

    default void deleteMin(){
        delete(min());
    }

    default void deleteMax(){
        delete(max());
    }

    default Iterable<X> keys() {
        return keys(min(), max());
    }

    int size(X lo, X hi);

    Iterable<X> keys(X lo, X hi);
}
