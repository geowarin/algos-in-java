package com.algos.structure.tree;

import com.algos.sort.SorterHelper;
import com.algos.structure.symboltable.TableSupplier;

/**
 * User: sennen
 * Date: 16/03/2014
 * Time: 15:56
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private final TableSupplier<T> tableSupplier;
    private Integer[] priorities;
    private Integer[] prioritiesIndices;
    private T[] items;
    private int length = 0;

    public IndexMinPriorityQueue(TableSupplier<T> tableSupplier) {
        this.tableSupplier = tableSupplier;
    }

    public void insert(int index, T item) {
        adjustSpaceIfNeeded(index);
        if (contains(index)) {
            return;
        }
        length++;
        swim(index, item);
    }

    public void update(int index, T item) {
        adjustSpaceIfNeeded(index);
        if (!contains(index)) {
            return;
        }
        Integer tableIndex = prioritiesIndices[index];
        items[tableIndex] = item;
    }

    public boolean contains(int index) {
        return prioritiesIndices != null && prioritiesIndices.length > index && prioritiesIndices[index] != null;
    }

    public void delete(int priority) {
        Integer priorityIndex = prioritiesIndices[priority];
        breakQueueOrder(priorityIndex);

        deleteEntry(priority);
        length--;

        sink(priorityIndex);
    }

    public T peek() {
        return items[1];
    }

    public int peekIndex() {
        return priorities[1];
    }

    public T poll() {
        T item = peek();
        delete(priorities[1]);
        return item;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    private void adjustSpaceIfNeeded(int index) {
        priorities = QueueUtils.adjustSpaceIfNeeded(priorities, Integer[]::new, length);
        items = QueueUtils.adjustSpaceIfNeeded(items, tableSupplier, length);
        prioritiesIndices = QueueUtils.adjustSpaceIfNeeded(prioritiesIndices, Integer[]::new, index + 1);
    }

    private void swim(int index, T item) {
        priorities[length] = index;
        items[length] = item;
        prioritiesIndices[index] = length;

        int position = length;
        while (position > 1 && SorterHelper.greater(priorities[position / 2], priorities[position])) {
            SorterHelper.exchange(priorities, position, position / 2);
            SorterHelper.exchange(items, position, position / 2);
            prioritiesIndices[priorities[position]] = position;
            prioritiesIndices[priorities[position / 2]] = position / 2;
            position /= 2;
        }
    }

    private void sink(int index) {
        int position = index;

        while (2 * position <= length) {
            int j = 2 * position;
            if (j < length && SorterHelper.greater(priorities[j], priorities[j + 1])) {
                j++;
            }
            if (SorterHelper.lesser(priorities[position], priorities[j])) {
                break;
            }
            SorterHelper.exchange(priorities, position, j);
            SorterHelper.exchange(items, position, j);
            prioritiesIndices[priorities[position]] = position;
            prioritiesIndices[priorities[j]] = j;
            position = j;
            position *= 2;
        }
    }

    private void deleteEntry(int index) {
        prioritiesIndices[index] = null;
        priorities[length] = null;
        items[length] = null;
    }

    private void breakQueueOrder(Integer priorityIndex) {
        prioritiesIndices[priorities[length]] = priorityIndex;
        SorterHelper.exchange(items, priorityIndex, length);
        SorterHelper.exchange(priorities, priorityIndex, length);
    }
}
