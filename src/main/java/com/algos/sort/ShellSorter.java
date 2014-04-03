package com.algos.sort;

import static com.algos.sort.SorterHelper.lesser;

/**
 * @author Sennen
 * @since 27/09/13 00:48
 *        Insertion sort is slow on large unordered arrays.
 *        Shell sort address this problem by limiting exchanges.
 */
public class ShellSorter<T extends Comparable<T>> implements Sorter<T> {
    private static final int INITIAL_K = 3;

    @Override
    public T[] sort(T[] tableToSort) {
        int initialStep = getInitialStep(tableToSort);
        for (int currentStep = initialStep; currentStep > 0; currentStep /= INITIAL_K) {
            shiftLeftEveryElementLesserThanPreviousForStepFrom(currentStep, tableToSort);
        }
        return tableToSort;
    }

    private int getInitialStep(T[] tableToSort) {
        int h = 1;
        int size = tableToSort.length;
        while (h < size / INITIAL_K) {
            h = h * INITIAL_K + 1;
        }
        return h;
    }

    private void shiftLeftEveryElementLesserThanPreviousForStepFrom(int currentStep, T[] tableToSort) {
        for (int index = 0; index < tableToSort.length; index += currentStep) {
            shiftLeftEveryElementLesserThanPreviousFrom(index, currentStep, tableToSort);
        }
    }

    private void shiftLeftEveryElementLesserThanPreviousFrom(int index, int step, T[] tableToSort) {
        for (int currentIndex = index;
             currentIndex > 0 && lesser(tableToSort[currentIndex], tableToSort[currentIndex - step]);
             currentIndex -= step) {
            shiftLeftElement(currentIndex, step, tableToSort);
        }
    }

    private void shiftLeftElement(int currentIndex, int step, T[] tableToSort) {
        T element = tableToSort[currentIndex];
        tableToSort[currentIndex] = tableToSort[currentIndex - step];
        tableToSort[currentIndex - step] = element;
    }
}
