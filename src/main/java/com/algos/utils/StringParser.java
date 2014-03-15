package com.algos.utils;

import java.io.IOException;

/**
 * @author Sennen
 * @since 31/12/13 22:08
 */
public abstract class StringParser {

    public static int[] parseIntegers(String line) throws IOException {
        String[] intValuesString = line.split(" ");
        int[] intValues = new int[intValuesString.length];
        for (int i = 0; i < intValues.length; i++) {
            intValues[i] = Integer.parseInt(intValuesString[i]);
        }
        return intValues;
    }
}
