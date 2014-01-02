package com.algos.union;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 31/12/13 22:33
 */
public class QuickUnionConnector implements Connector {
    protected final int[] nodeIdentifiers;
    protected int numberOfComponents;

    public QuickUnionConnector(int numberOfNodes) {
        numberOfComponents = numberOfNodes;
        nodeIdentifiers = new int[numberOfNodes];
        Arrays.setAll(nodeIdentifiers, index -> index);
    }

    @Override
    public void union(int node, int otherNode) {
        int nodeRoot = find(node);
        int otherNodeRoot = find(otherNode);
        if (nodeRoot == otherNodeRoot) {
            return;
        }
        nodeIdentifiers[nodeRoot] = otherNodeRoot;
        numberOfComponents--;
    }

    @Override
    public int find(int node) {
        int identifier = nodeIdentifiers[node];
        while (identifier != nodeIdentifiers[identifier])  {
            identifier = nodeIdentifiers[identifier];
        }
        return identifier;
    }

    @Override
    public int getNumberOfComponents() {
        return numberOfComponents;
    }
}
