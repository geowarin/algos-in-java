package com.algos.structure.symboltable;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyCounterUtil {
    public static final String EMPTY = "";

    public static Map.Entry<String, Integer> findHighestFrequencyCount(SymbolTable<String, Integer> table) {
        Map.Entry<String, Integer> maxFrequencyCount = new Pair<>(EMPTY, 0);
        for (String word : table.keys()) {
            Integer frequencyCount = table.get(word);
            if (frequencyCount > maxFrequencyCount.getValue()) {
                maxFrequencyCount = new Pair<>(word, frequencyCount);
            }
        }
        return maxFrequencyCount;
    }

    public static Map.Entry<String, Integer>
    getMaxFrequencyCount(String fileName, SymbolTable<String, Integer> symbolTable, Logger logger)
            throws Exception {
        return getMaxFrequencyCount(fileName, symbolTable, 1, logger);
    }

    public static Map.Entry<String, Integer>
    getMaxFrequencyCount(String fileName, SymbolTable<String, Integer> symbolTable, int minWordSize, Logger logger)
            throws Exception {
        long init = new Date().getTime();
        FrequencyCounterUtil.loadSymbolTable(symbolTable, fileName, minWordSize);
        Map.Entry<String, Integer> maxFrequency = FrequencyCounterUtil.findHighestFrequencyCount(symbolTable);
        logger.debug("How long ? " + (new Date().getTime() - init) + "\t\t For which size ? " +
                     symbolTable.size());
        return maxFrequency;
    }

    private static void loadSymbolTable(SymbolTable<String, Integer> table, String fileName, int minLength)
            throws Exception {
        BufferedReader reader =
                new BufferedReader(new FileReader(new File(FrequencyCounterUtil.class.getResource(fileName).toURI())));
        String line = reader.readLine();
        while (line != null) {
            List<String> words = getWords(line);
            for (String word : words) {
                if (word.length() < minLength) {
                    continue;
                }
                if (!table.contains(word)) {
                    table.put(word, 1);
                } else {
                    table.put(word, table.get(word) + 1);
                }
            }
            line = reader.readLine();
        }
    }

    private static List<String> getWords(String line) {
        Pattern wordPattern = Pattern.compile("\\w+");
        Matcher wordMatcherForLine = wordPattern.matcher(line);
        List<String> wordList = new ArrayList<>();
        while (wordMatcherForLine.find()) {
            wordList.add(wordMatcherForLine.group());
        }
        return wordList;
    }
}
