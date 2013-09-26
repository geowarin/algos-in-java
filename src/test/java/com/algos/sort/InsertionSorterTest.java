package com.algos.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sennen
 * @since 26/09/13 21:55
 */
public class InsertionSorterTest extends SorterTestCase {
    @Test
    public void testSort() throws Exception {
        InsertionSorter<Character> sorter = new InsertionSorter<Character>();
        Character[] actualTable = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        sorter.sort(actualTable);
        print(actualTable);
        assertArrayEquals(
                new Character[]{'A', 'E', 'E', 'E', 'E', 'G', 'L', 'M', 'M', 'O', 'P', 'R', 'R', 'S', 'T', 'X'},
                actualTable);
    }
}
