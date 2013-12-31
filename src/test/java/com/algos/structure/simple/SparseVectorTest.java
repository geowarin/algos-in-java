package com.algos.structure.simple;

import com.algos.structure.simple.SparseVector;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Sennen
 * @since 23/12/13 23:50
 */
public class SparseVectorTest {
    private static final double[] VECTOR = {0., 0.3, 0.4, 0., 0.1};

    private SparseVector sparseVector = new SparseVector();

    @Test
    public void testDot() throws Exception {
        sparseVector.put(1, 1.);
        assertEquals(0.3, sparseVector.dot(VECTOR));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, sparseVector.size());
        sparseVector.put(1, 1.);
        assertEquals(1, sparseVector.size());
    }
}
