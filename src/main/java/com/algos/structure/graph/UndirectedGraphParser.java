package com.algos.structure.graph;

import com.algos.utils.StringParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Sennen
 * @since 31/12/13 15:22
 */
public abstract class UndirectedGraphParser {
    public static UndirectedGraph<Integer> parseToIntegerGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int[] valueOfV = StringParser.parseIntegers(reader.readLine());
            SimpleUndirectedGraph undirectedGraph = new SimpleUndirectedGraph(valueOfV[0]);
            String line = reader.readLine();
            while (line != null) {
                int[] linkedVertices = StringParser.parseIntegers(line);
                undirectedGraph.addEdge(linkedVertices[0], linkedVertices[1]);
                line = reader.readLine();
            }
            return undirectedGraph;
        }
    }

    public static UndirectedSymbolGraph<String> parseToStringGraph(String filePath, String delimiter)
            throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            UndirectedSymbolGraph<String> undirectedGraph =
                    new ExtensibleUndirectedSymbolGraph<>(size -> new String[size]);
            String line = reader.readLine();
            while (line != null) {
                String[] linkedVertices = line.split(delimiter);
                undirectedGraph.addEdge(linkedVertices[0], linkedVertices[1]);
                line = reader.readLine();
            }
            return undirectedGraph;
        }

    }
}
