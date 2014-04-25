package com.algos.structure.simple;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * User: sennen
 * Date: 11/04/2014
 * Time: 06:45
 */
public class TableIteratorTest {
    private static final Character[] CHARACTERS = {'a', 'b', 'c', 'd', 'e'};

    @Test
    public void testIterate() throws Exception {
        LinkedList<Character> expectedChars = new LinkedList<>();
        expectedChars.add('b');
        expectedChars.add('c');
        expectedChars.add('d');

        Iterator<Character> actualCharacters = new TableIterator<>(CHARACTERS, 1, 3);
        for (Character actualCharacter = actualCharacters.next(); actualCharacters.hasNext();
             actualCharacter = actualCharacters.next()) {
            TestCase.assertEquals(expectedChars.poll(), actualCharacter);
        }
    }
}
