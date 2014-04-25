package com.algos.union;

/**
 * This class is a representation of a network and helps found connections between nodes.
 * @author Sennen
 * @since 31/12/13 21:36
 */
public interface Connector {
    /**
     * Connects 2 nodes of the network into the same component
     * @param node First node to connect
     * @param otherNode Other node to connect
     */
    void union(int node, int otherNode);

    /**
     * Finds the identifier of a node
     * @param node The node to find
     * @return The node identifier
     */
    int find(int node);

    default boolean connected(int node, int otherNode) {
        return find(node) == find(otherNode);
    }

    int getNumberOfComponents();
}
