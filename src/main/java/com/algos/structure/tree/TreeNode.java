package com.algos.structure.tree;

/**
 * User: sennen
 * Date: 15/03/2014
 * Time: 23:05
 */
public class TreeNode<X extends Comparable<X>, Y> {
    private X key;
    private Y value;
    private TreeNode<X, Y> leftNode;
    private TreeNode<X, Y> rightNode;
    private int size;

    public TreeNode(X key, Y value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }

    public X getKey() {
        return key;
    }

    public Y getValue() {
        return value;
    }

    public TreeNode<X, Y> getLeftNode() {
        return leftNode;
    }

    public TreeNode<X, Y> getRightNode() {
        return rightNode;
    }

    public void setValue(Y value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode<X, Y> leftNode) {
        this.leftNode = leftNode;
        adjustSize();
    }

    public void setRightNode(TreeNode<X, Y> rightNode) {
        this.rightNode = rightNode;
        adjustSize();
    }

    public int getSize() {
        return size;
    }

    private void adjustSize() {
        int leftSize = leftNode == null ? 0 : leftNode.getSize();
        int rightSize = rightNode == null ? 0 : rightNode.getSize();
        size = leftSize + rightSize + 1;
    }

    @Override
    public String toString() {
        StringBuilder nodeStringBuilder = new StringBuilder(toString(this));
        nodeStringBuilder.append(", leftNode=").append(toString(getLeftNode()))
                .append(", rightNode=").append(toString(getRightNode()))
                .append('}');

        return nodeStringBuilder.toString();
    }

    private static String toString(TreeNode<? extends Comparable, ?> node) {
        if (node == null) {
            return "null";
        }
        StringBuilder nodeStringBuilder = new StringBuilder();
        nodeStringBuilder.append("TreeNode {")
                .append("key=").append(node.getKey())
                .append(", value=").append(node.getValue())
                .append(", size=").append(node.getSize())
                .append("}");
        return nodeStringBuilder.toString();
    }
}
