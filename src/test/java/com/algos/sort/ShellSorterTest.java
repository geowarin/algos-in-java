package com.algos.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sennen
 * @since 27/09/13 00:59
 */
public class ShellSorterTest extends SorterTestCase {
    @Test
    public void test() throws Exception {
        ShellSorter<Character> sorter = new ShellSorter<Character>();
        Character[] actualTable = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        sorter.sort(actualTable);
        print(actualTable);
        assertArrayEquals(
                new Character[]{'A', 'E', 'E', 'E', 'E', 'G', 'L', 'M', 'M', 'O', 'P', 'R', 'R', 'S', 'T', 'X'},
                actualTable);
    }
}
