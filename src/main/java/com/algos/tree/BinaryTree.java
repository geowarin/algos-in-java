package com.algos.tree;

import com.google.common.base.Strings;

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

	public static void print(BinaryTree tree) {
		int spaces = tree.size();
		BinaryTree.Node root = tree.root;

		System.out.println(Strings.padStart(root.val.toString(), spaces, ' '));


		System.out.println(Strings.padStart("/", spaces - 1, ' '));
		System.out.println(Strings.padStart("\\", spaces + 1, ' '));
	}

	// See page 399.
	// See page 407 for min(), max(), floor(), and ceiling().
	// See page 409 for select() and rank().
	// See page 411 for delete(), deleteMin(), and deleteMax().
	// See page 413 for keys().
}
