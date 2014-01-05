package com.algos.structure.symboltable;

/**
 * @author Sennen
 * @since 23/12/13 04:04
 */
public class HashSet<T> implements Set<T> {
    private final TableSupplier<T> elementsTableSupplier;
    private T[] elements;
    private int sizeOfLinearProbing;
    private int size;

    public HashSet(TableSupplier<T> elementsTableSupplier) {
        this(16, elementsTableSupplier);
    }

    public HashSet(int sizeOfLinearProbing, TableSupplier<T> elementsTableSupplier) {
        this.sizeOfLinearProbing = sizeOfLinearProbing;
        this.elementsTableSupplier = elementsTableSupplier;
        elements = elementsTableSupplier.get(sizeOfLinearProbing);
    }

    @Override
    public void add(T element) {
        int elementIndex = getIndex(element);
        if (elements[elementIndex] != null) {
            return;
        }
        resizeIfNecessary(() -> size >= sizeOfLinearProbing / 2, 2 * sizeOfLinearProbing);
        elements[elementIndex] = element;
        size++;
    }

    @Override
    public void delete(T element) {
        int elementIndex = getIndex(element);
        if (elements[elementIndex] == null) {
            return;
        }
        elements[elementIndex] = null;
        size--;
        for (int i = (elementIndex + 1) % sizeOfLinearProbing; elements[i] != null; i = (i + 1) % sizeOfLinearProbing) {
            size--;
            T elementToAdd = elements[i];
            elements[i] = null;
            add(elementToAdd);
        }
        resizeIfNecessary(() -> size > 0 && sizeOfLinearProbing <= sizeOfLinearProbing / 8, sizeOfLinearProbing / 2);
    }

    @Override
    public boolean contains(T element) {
        return elements[getIndex(element)] != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(T element) {
        int index = hash(element);
        for (; elements[index] != null; index = (index + 1) % sizeOfLinearProbing) {
            if (element.equals(elements[index])) {
                break;
            }
        }
        return index;
    }

    private int hash(T key) {
        return (key.hashCode() & 0x7fffffff) % sizeOfLinearProbing;
    }

    private void resizeIfNecessary(SimplePredicate predicate, int newCapacity) {
        if (predicate.test()) {
            readjustTable(newCapacity);
        }
    }

    private void readjustTable(int newCapacity) {
        sizeOfLinearProbing = newCapacity;
        size = 0;
        T[] oldElements = this.elements;
        this.elements = elementsTableSupplier.get(newCapacity);
        for (T element : oldElements) {
            if (element != null) {
                add(element);
            }
        }
    }
}
