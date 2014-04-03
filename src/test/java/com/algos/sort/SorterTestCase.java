package com.algos.sort;

import org.slf4j.Logger;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sennen
 * @since 26/09/13 21:59
 */
public class SorterTestCase {

    private static final String BEGIN_SEPARATOR = "'";
    private static final String MIDDLE_SEPARATOR = "', ";
    private static final String END_SEPARATOR = "'";

    static void testSorter(Sorter<Character> sorter, Logger logger) {
        Character[] actualTable = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Character[] actualTableSorted = sorter.sort(actualTable);
        print(actualTableSorted, logger);
        assertArrayEquals(
                new Character[]{'A', 'E', 'E', 'E', 'E', 'G', 'L', 'M', 'M', 'O', 'P', 'R', 'R', 'S', 'T', 'X'},
                actualTableSorted);
    }

    private static <T> void print(T[] tableToPrint, Logger logger) {
        int size = tableToPrint.length;
        StringBuilder printString = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            T element = tableToPrint[i];
            printString.append(BEGIN_SEPARATOR).append(element).append(MIDDLE_SEPARATOR);
        }
        printString.append(BEGIN_SEPARATOR).append(tableToPrint[size - 1]).append(END_SEPARATOR);
        logger.debug(printString.toString());
    }
}
