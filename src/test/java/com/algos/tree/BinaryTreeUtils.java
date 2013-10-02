package com.algos.tree;

public class BinaryTreeUtils {
	public static BinaryTree<Integer, String> testTree() {
		BinaryTree<Integer, String> tree = new BinaryTree<>();
		tree.put(5, "5");
		tree.put(6, "6");
		tree.put(4, "4");
		tree.put(3, "3");
		tree.put(10, "10");
		tree.put(12, "12");
		tree.put(9, "9");
		return tree;
	}
}
