package com.algos.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
		private List<BinaryTree.Node> levelNodes = new ArrayList<>();

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
				System.out.print("n");
			}
			levelNodes.add(node);
			printBetweenSpaces(0);
		}

		private void printBetweenSpaces(int add) {
			printWhitespaces((int) Math.pow(2, maxLevel - level + 1) - 1 + add);
		}

		private void onLevel(Integer level) {
			this.level = level;
			int startWs = (int) Math.pow(2, maxLevel - level) - 1;
			if (level > 1) {
				System.out.println();
				printEdges();
				levelNodes.clear();
			}
			// Print start whitespaces
			printWhitespaces(startWs);
		}

		private void printEdges() {
			int floor = maxLevel - level;
			int startWs = (int) Math.pow(2, floor + 1);
			int numberOfLines = (int) Math.pow(2, Math.max(floor, 0));

			for (int lineNum = 0; lineNum < numberOfLines; lineNum++) {
				for (BinaryTree.Node levelNode : levelNodes) {

					if (levelNode == null) {
//						System.out.print(Strings.repeat("*", startWs - lineNum + 2 * lineNum));
//						printWhitespaces(startWs - lineNum);

						printWhitespaces(startWs - lineNum - 2);
						System.out.print("/");
						printWhitespaces(2 * lineNum + 1);
						System.out.print("\\");

						continue;
					}
					printWhitespaces(startWs - lineNum - 2);
					System.out.print("/");
//					System.out.print(levelNode.left != null ? "/" : " ");
					printWhitespaces(2 * lineNum + 1);
					System.out.print("\\");
					printWhitespaces(1);
//					System.out.print(levelNode.right != null ? "\\" : " ");
				}
				System.out.println();
			}
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
