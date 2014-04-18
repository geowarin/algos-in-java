package com.algos.structure.tree;

/**
 * User: sennen
 * Date: 05/04/2014
 * Time: 17:13
 */
public class BinaryTreeNode<X, Y> {
    private final X key;
    private Y value;
    private int size;
    private BinaryTreeNode<X, Y> leftNode;
    private BinaryTreeNode<X, Y> rightNode;

    public BinaryTreeNode(X key, Y value) {
        this.key = key;
        this.value = value;
        size = 1;
    }

    public X getKey() {
        return key;
    }

    public Y getValue() {
        return value;
    }

    public BinaryTreeNode<X, Y> getLeftNode() {
        return leftNode;
    }

    public BinaryTreeNode<X, Y> getRightNode() {
        return rightNode;
    }

    public void setValue(Y value) {
        this.value = value;
    }

    public void setLeftNode(BinaryTreeNode<X, Y> leftNode) {
        this.leftNode = leftNode;
        adjustSize();
    }

    public void setRightNode(BinaryTreeNode<X, Y> rightNode) {
        this.rightNode = rightNode;
        adjustSize();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder nodeStringBuilder = new StringBuilder(toString(this));
        nodeStringBuilder.append(", leftNode=").append(toString(leftNode))
                         .append(", rightNode=").append(toString(rightNode))
                         .append('}');

        return nodeStringBuilder.toString();
    }

    private String toString(BinaryTreeNode<X, Y> node) {
        if (node == null) {
            return "null";
        }
        StringBuilder nodeStringBuilder = new StringBuilder();
        nodeStringBuilder.append("BTNodeImpl{")
                         .append("key=").append(node.getKey())
                         .append(", value=").append(node.getValue())
                         .append(", size=").append(node.getSize())
                         .append("}");
        return nodeStringBuilder.toString();
    }

    void adjustSize() {
        size = size(leftNode) + size(rightNode) + 1;
    }

    private static <X, Y> int size(BinaryTreeNode<X, Y> node) {
        return node == null ? 0 : node.getSize();
    }
}
