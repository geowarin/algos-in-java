package com.algos.structure.symboltable;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.fest.assertions.Assertions.assertThat;

/**
* @author Sennen
* @since 25/10/13 01:33
*/
class IteratorAssert<T> {
    private Iterator<T> actualIterator;

    IteratorAssert(Iterator<T> actualIterator) {
        this.actualIterator = actualIterator;
    }

    public IteratorAssert<T> nextEquals(T next) {
        hasNext();
        assertThat(next).isEqualTo(actualIterator.next());
        return this;
    }

    public IteratorAssert<T> hasNext() {
        assertTrue("Iterator should have next item", actualIterator.hasNext());
        return this;
    }

    public IteratorAssert<T> hasNoNext() {
        assertFalse("Iterator should not have next item", actualIterator.hasNext());
        return this;
    }
}
