package com.algos.structure.symboltable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Sennen
 * @since 23/12/13 04:39
 */
public class HashSetTest {
    private static final String ANYTHING = "ANYTHING";
    private static final String CHRISTOPHE = "CHRISTOPHE";
    private static final String SENNEN = "SENNEN";
    private static final String NINI = "NINI";
    private static final String FATOU = "FATOU";
    private static final String KEYO = "KEYO";
    private static final String JO = "JO";

    private Set<String> namesSet;

    @Before
    public void setUp() {
        namesSet = new HashSet<>(String[]::new);
        namesSet.add(CHRISTOPHE);
        namesSet.add(SENNEN);
        namesSet.add(NINI);
        namesSet.add(FATOU);
        namesSet.add(KEYO);
        namesSet.add(JO);
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(namesSet.contains(CHRISTOPHE));
        assertTrue(namesSet.contains(SENNEN));
        assertTrue(namesSet.contains(NINI));
        assertTrue(namesSet.contains(FATOU));
        assertTrue(namesSet.contains(KEYO));
        assertTrue(namesSet.contains(JO));
        assertFalse(namesSet.contains(ANYTHING));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(6, namesSet.size());
        namesSet.delete(SENNEN);
        assertEquals(5, namesSet.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(namesSet.isEmpty());
        namesSet.delete(CHRISTOPHE);
        namesSet.delete(SENNEN);
        namesSet.delete(NINI);
        namesSet.delete(FATOU);
        namesSet.delete(KEYO);
        namesSet.delete(JO);
        assertTrue(namesSet.isEmpty());
    }
}
