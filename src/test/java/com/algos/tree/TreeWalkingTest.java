package com.algos.tree;

import org.junit.Test;

public class TreeWalkingTest {

	@Test
	public void testBreadth() throws Exception {
		BinaryTree<Integer, String> tree = BinaryTreeUtils.testTree();
		BinaryTree.BTreePrinter.printTree(tree);
		new BinaryTreePrinter(tree).print();
	}

	public static class BinaryTreePrinter {
		private final BinaryTree tree;
		private final int maxLevel;
		private Integer level;

		public BinaryTreePrinter(BinaryTree tree) {
			this.tree = tree;
			this.maxLevel = maxLevel(tree.root);
		}

		public void print() {
			TreeWalking.breadth(tree, this::onNode, this::onLevel);
		}

		private void onNode(BinaryTree.Node node) {
			if (node != null) {
				System.out.print(node.key);
			} else {
				System.out.print(" ");
			}
			printWhitespaces((int) Math.pow(2, maxLevel - level + 1) - 1);
		}

		private void onLevel(Integer level) {
			this.level = level;
			if (level > 1) {
				System.out.println();
			}
			printWhitespaces((int) (Math.pow(2, maxLevel - level) - 1));
		}

		private static int maxLevel(BinaryTree.Node node) {
			if (node == null)
				return 0;

			return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
		}

		private static void printWhitespaces(int count) {
			for (int i = 0; i < count; i++)
				System.out.print(" ");
		}
	}
}
