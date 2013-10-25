package com.algos.structure.symboltable;

import java.util.Iterator;

/**
 * @author Sennen
 * @since 25/10/13 01:34
 */
public class SymbolTableTestCase {
    public static final String ANYTHING = "ANYTHING";
    static final String CHRISTOPHE = "CHRISTOPHE";
    static final String SENNEN = "SENNEN";
    static final String NINI = "NINI";
    static final String FATOU = "FATOU";
    static final String KEYO = "KEYO";
    static final String JO = "JO";
    protected SymbolTable<String, Integer> nameToAgeHashSymbolTable;

    protected static <T> IteratorAssert<T> assertThatIterator(Iterator<T> actualIterator) {
        return new IteratorAssert<>(actualIterator);
    }

    public void setUp(SymbolTable<String, Integer> nameToAgeHashSymbolTable) {
        this.nameToAgeHashSymbolTable = nameToAgeHashSymbolTable;
        this.nameToAgeHashSymbolTable.put(SENNEN, 26);
        this.nameToAgeHashSymbolTable.put(NINI, 26);
        this.nameToAgeHashSymbolTable.put(CHRISTOPHE, 32);
        this.nameToAgeHashSymbolTable.put(FATOU, 25);
        this.nameToAgeHashSymbolTable.put(KEYO, 22);
        this.nameToAgeHashSymbolTable.put(JO, 20);
    }
}
