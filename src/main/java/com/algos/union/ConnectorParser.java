package com.algos.union;

import com.algos.utils.StringParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * @author Sennen
 * @since 31/12/13 15:22
 */
public abstract class ConnectorParser {
    public static Connector parse(String filePath, Function<Integer, ? extends Connector> connectorSupplier) throws
                                                                                                             IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int[] sizeOfNetwork = StringParser.parseIntegers(reader.readLine());
            Connector connector = connectorSupplier.apply(sizeOfNetwork[0]);
            String line = reader.readLine();
            while (line != null) {
                int[] linkedVertices = StringParser.parseIntegers(line);
                connector.union(linkedVertices[0], linkedVertices[1]);
                line = reader.readLine();
            }
            return connector;
        }
    }

}
