package com.algos.structure.tree.priorityqueue;

import com.algos.structure.symboltable.TableSupplier;

import java.util.Arrays;

/**
 * User: sennen
 * Date: 16/03/2014
 * Time: 19:44
 */
public class Queues {

    public static <T> T[] adjustSpaceIfNeeded(T[] items, TableSupplier<T> tableSupplier, int length) {
        if (items == null) {
            return tableSupplier.get(16);
        }
        int availableSpace = items.length;
        if (length == availableSpace / 4) {
            items = Arrays.copyOf(items, availableSpace * 2);
        }
        return items;
    }
}
