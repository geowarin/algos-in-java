package com.algos.union;

import java.util.Arrays;

/**
 * @author Sennen
 * @since 31/12/13 23:05
 */
public class WeightedQuickUnionConnector extends QuickUnionConnector {
    private final int[] sizes;

    public WeightedQuickUnionConnector(int numberOfNodes) {
        super(numberOfNodes);
        sizes = new int[numberOfNodes];
        Arrays.setAll(sizes, index -> 1);
    }

    @Override
    public void union(int node, int otherNode) {
        int nodeRoot = find(node);
        int otherNodeRoot = find(otherNode);
        if (nodeRoot == otherNodeRoot) {
            return;
        }
        if (sizes[nodeRoot] < sizes[otherNode]) {
            nodeIdentifiers[nodeRoot] = otherNodeRoot;
        } else if (sizes[nodeRoot] == sizes[otherNode]) {
            nodeIdentifiers[otherNodeRoot] = nodeRoot;
            sizes[nodeRoot]++;
        } else {
            nodeIdentifiers[otherNodeRoot] = nodeRoot;
        }
        this.numberOfComponents--;
    }
}
