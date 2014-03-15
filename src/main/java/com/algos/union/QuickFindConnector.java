package com.algos.union;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 31/12/13 21:45
 */
public class QuickFindConnector implements Connector {
    private final int[] nodeIdentifiers;
    private int numberOfComponents;

    public QuickFindConnector(int numberOfNodes) {
        numberOfComponents = numberOfNodes;
        nodeIdentifiers = new int[numberOfNodes];
        Arrays.setAll(nodeIdentifiers, index -> index);
    }

    @Override
    public void union(int node, int otherNode) {
        int componentIdentifier = find(node);
        int otherComponentIdentifier = find(otherNode);
        if(componentIdentifier == otherComponentIdentifier) {
            return;
        }
        for (int i = 0; i < nodeIdentifiers.length; i++) {
            if(nodeIdentifiers[i] == componentIdentifier) {
                nodeIdentifiers[i] = otherComponentIdentifier;
            }
        }
        numberOfComponents--;
    }

    @Override
    public int find(int node) {
        return nodeIdentifiers[node];
    }

    @Override
    public int getNumberOfComponents() {
        return numberOfComponents;
    }
}
