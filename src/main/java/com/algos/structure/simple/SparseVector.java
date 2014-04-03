package com.algos.structure.simple;

import com.algos.structure.symboltable.LinearProbingHashSymbolTable;
import com.algos.structure.symboltable.SymbolTable;

/**
 * @author Sennen
 * @since 23/12/13 23:48
 */
public class SparseVector {
    private SymbolTable<Integer, Double> symbolTable;

    public SparseVector() {
        symbolTable = new LinearProbingHashSymbolTable<>(Integer[]::new, Double[]::new);
    }

    public int size() {
        return symbolTable.size();
    }

    public void put(int i, double x) {
        symbolTable.put(i, x);
    }

    public double get(int i) {
        if (!symbolTable.contains(i)) {
            return 0.0;
        } else {
            return symbolTable.get(i);
        }
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : symbolTable.keys()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }
}
