package com.algos.sort;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: sennen
 * Date: 07/04/2014
 * Time: 13:33
 */
public class SorterHelperTest {
    @Test
    public void testStrictlyLesser() throws Exception {
        TestCase.assertTrue(SorterHelper.strictlyLesser(3, 4));
        TestCase.assertFalse(SorterHelper.strictlyLesser(4, 4));
        TestCase.assertFalse(SorterHelper.strictlyLesser(5, 4));
    }

    @Test
    public void testLesser() throws Exception {
        TestCase.assertTrue(SorterHelper.lesser(3, 4));
        TestCase.assertTrue(SorterHelper.lesser(4, 4));
        TestCase.assertFalse(SorterHelper.lesser(5, 4));
    }

    @Test
    public void testStrictlyGreater() throws Exception {
        TestCase.assertFalse(SorterHelper.strictlyGreater(3, 4));
        TestCase.assertFalse(SorterHelper.strictlyGreater(4, 4));
        TestCase.assertTrue(SorterHelper.strictlyGreater(5, 4));
    }

    @Test
    public void testGreater() throws Exception {
        TestCase.assertFalse(SorterHelper.greater(3, 4));
        TestCase.assertTrue(SorterHelper.greater(4, 4));
        TestCase.assertTrue(SorterHelper.greater(5, 4));
    }
}
