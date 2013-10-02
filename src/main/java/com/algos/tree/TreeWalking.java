package com.algos.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class TreeWalking {

	private static boolean ACCEPT_NULLS = true;

	public static void breadth(BinaryTree tree, Consumer<BinaryTree.Node> onNode, Consumer<Integer> onNewLevel) {
		new BreadthWalker(tree, onNode, onNewLevel).walk();
	}

	private static class BreadthWalker {
		private final BinaryTree tree;
		private final Consumer<BinaryTree.Node> onNode;
		private final Consumer<Integer> onNewLevel;
		private int level;

		private BreadthWalker(BinaryTree tree, Consumer<BinaryTree.Node> onNode, Consumer<Integer> onNewLevel) {
			this.tree = tree;
			this.onNode = onNode;
			this.onNewLevel = onNewLevel;
		}

		void walk() {
			this.level = 0;

			Queue<BinaryTree.Node> nextLevel = new LinkedList<>(Collections.singletonList(tree.root));
			while (!nextLevel.isEmpty() && containsOneNotNull(nextLevel)) {
				onNewLevel.accept(++level);
				Queue<BinaryTree.Node> nextNodes = walkLevelAndReturnNext(nextLevel);
				nextLevel.addAll(nextNodes);
			}
		}

		private Queue<BinaryTree.Node> walkLevelAndReturnNext(Queue<BinaryTree.Node> levelNodes) {
			Queue<BinaryTree.Node> nextNodes = new LinkedList<>();
			while (!levelNodes.isEmpty()) {
				BinaryTree.Node currentNode = levelNodes.poll();
				if (currentNode != null) {
					nextNodes.add(currentNode.left);
					nextNodes.add(currentNode.right);
				} else if (ACCEPT_NULLS) {
					nextNodes.add(null);
					nextNodes.add(null);
				}
				onNode.accept(currentNode);
			}
			return nextNodes;
		}

	}

	private static <T> boolean containsOneNotNull(Queue<T> queue) {
		return queue.stream().anyMatch(e -> e != null);
	}
}
