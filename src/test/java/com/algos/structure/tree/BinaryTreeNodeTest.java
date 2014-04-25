package com.algos.structure.tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: sennen
 * Date: 05/04/2014
 * Time: 17:22
 */
public class BinaryTreeNodeTest {
    @Test
    public void testSize() throws Exception {
        BinaryTreeNode<String, Integer> binaryTreeNode = new BinaryTreeNode<>("key", 0);
        TestCase.assertEquals(1, binaryTreeNode.getSize());
        BinaryTreeNode<String, Integer> childTreeNode = new BinaryTreeNode<>("childKey", 3);
        binaryTreeNode.setLeftNode(childTreeNode);
        TestCase.assertEquals(2, binaryTreeNode.getSize());
    }
}
