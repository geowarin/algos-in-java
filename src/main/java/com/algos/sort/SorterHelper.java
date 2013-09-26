package com.algos.sort;

/**
 * @author Sennen
 * @since 26/09/13 22:10
 */
public class SorterHelper {
    static <T extends Comparable<T>> boolean lesser(T elementSupposedToBeGreater, T elementSupposedToBeLesser) {
        if (elementSupposedToBeGreater == null && elementSupposedToBeLesser == null) {
            return false;
        }
        if(elementSupposedToBeGreater == null) {
            return true;
        }
        if(elementSupposedToBeLesser == null) {
            return false;
        }
        return elementSupposedToBeGreater.compareTo(elementSupposedToBeLesser) < 0;
    }
}
