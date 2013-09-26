package com.algos.sort;

/**
 * @author Sennen
 * @since 26/09/13 21:59
 */
public class SorterTestCase {

    public static final String BEGIN_SEPARATOR = "'";
    public static final String MIDDLE_SEPARATOR = "', ";
    public static final String END_SEPARATOR = "'";

    static <T> void print(T[] tableToPrint) {
        int size = tableToPrint.length;
        for (int i = 0; i < size - 1; i++) {
            T element = tableToPrint[i];
            System.out.print(BEGIN_SEPARATOR + element + MIDDLE_SEPARATOR);
        }
        System.out.println(BEGIN_SEPARATOR + tableToPrint[size - 1] + END_SEPARATOR);
    }
}
