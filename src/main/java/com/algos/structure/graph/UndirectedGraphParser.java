package com.algos.structure.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Sennen
 * @since 31/12/13 15:22
 */
public abstract class UndirectedGraphParser {
    public static UndirectedGraph parse(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int[] valuesOfVAndE = parseIntegers(reader.readLine());
            SimpleUndirectedGraph undirectedGraph = new SimpleUndirectedGraph(valuesOfVAndE[0]);
            String line = reader.readLine();
            while (line != null) {
                int[] linkedVertices = parseIntegers(line);
                undirectedGraph.addEdge(linkedVertices[0], linkedVertices[1]);
                line = reader.readLine();
            }
            return undirectedGraph;
        }
    }

    private static int[] parseIntegers(String line) throws IOException {
        String[] valuesOfVAndEString = line.split(" ");
        int[] intValues = new int[valuesOfVAndEString.length];
        for (int i = 0; i < intValues.length; i++) {
            intValues[i] = Integer.parseInt(valuesOfVAndEString[i]);
        }
        return intValues;
    }

}
