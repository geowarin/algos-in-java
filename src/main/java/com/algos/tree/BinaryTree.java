package com.algos.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<Key extends Comparable<Key>, Value> {

	private Node root; // root of BST

	private class Node {
		private Key key; // key
		private Value val; // associated value
		private Node left, right; // links to subtrees
		private int N; // # nodes in subtree rooted here

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}


	public Value get(Key key) {

		Node current = root;
		while (current != null) {
			int cmp = key.compareTo(current.key);
			if (cmp == 0)
				return current.val;

			current = cmp < 0 ? current.left : current.right;
		}

		return null;
	}

	public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
		root = put(root, key, val);
	}

//  private Node put(Key key, Value val) {
//    while()
//  }

	private Node put(Node x, Key key, Value val) {
		// Change key’s value to val if key in subtree rooted at x.
		// Otherwise, add new node to subtree associating key with val.
		if (x == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	static class BTreePrinter {

		public static void printTree(BinaryTree tree) {
			printNode(tree.root);
		}

		public static void printNode(BinaryTree.Node root) {
			int maxLevel = BTreePrinter.maxLevel(root);
			printNodeInternal(Collections.singletonList(root), 1, maxLevel);
		}

		private static void printNodeInternal(List<BinaryTree.Node> nodes, int level, int maxLevel) {
			if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
				return;

			int floor = maxLevel - level;
			int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
			int firstSpaces = (int) Math.pow(2, (floor)) - 1;
			int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

			printWhitespaces(firstSpaces);

			List<BinaryTree.Node> newNodes = new ArrayList<>();
			for (BinaryTree.Node node : nodes) {
				if (node != null) {
					System.out.print(node.key);
					newNodes.add(node.left);
					newNodes.add(node.right);
				} else {
					newNodes.add(null);
					newNodes.add(null);
					System.out.print(" ");
				}

				printWhitespaces(betweenSpaces);
			}
			System.out.println("");

			for (int i = 1; i <= edgeLines; i++) {
				for (BinaryTree.Node node : nodes) {
					printWhitespaces(firstSpaces - i);
					if (node == null) {
						printWhitespaces(edgeLines + edgeLines + i + 1);
						continue;
					}

					if (node.left != null)
						System.out.print("/");
					else
						printWhitespaces(1);

					printWhitespaces(i + i - 1);

					if (node.right != null)
						System.out.print("\\");
					else
						printWhitespaces(1);

					printWhitespaces(edgeLines + edgeLines - i);
				}

				System.out.println("");
			}

			printNodeInternal(newNodes, level + 1, maxLevel);
		}

		private static void printWhitespaces(int count) {
			for (int i = 0; i < count; i++)
				System.out.print(" ");
		}

		private static int maxLevel(BinaryTree.Node node) {
			if (node == null)
				return 0;

			return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
		}

		private static <T> boolean isAllElementsNull(List<T> list) {
			return list.stream().filter(t -> t != null).count() == 0;
		}
	}

	// See page 399.
	// See page 407 for min(), max(), floor(), and ceiling().
	// See page 409 for select() and rank().
	// See page 411 for delete(), deleteMin(), and deleteMax().
	// See page 413 for keys().
}
