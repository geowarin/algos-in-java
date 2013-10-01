package com.algos.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class TreeWalking {

	public static void breadth(BinaryTree tree, Consumer<BinaryTree.Node> onNode, Consumer<Integer> onNewLevel) {
		Queue<BinaryTree.Node> nextNodes = new LinkedList<>();
		nextNodes.add(tree.root);
		int level = 0;
		while (!nextNodes.isEmpty() && containsOneNotNull(nextNodes)) {
			BinaryTree.Node currentNode = nextNodes.poll();
			if (currentNode != null) {
				nextNodes.add(currentNode.left);
				nextNodes.add(currentNode.right);
				onNode.accept(currentNode);
			}
			onNewLevel.accept(++level);
		}
	}

	private static <T> boolean containsOneNotNull(Queue<T> queue) {
		return queue.stream().anyMatch(e -> e != null);
	}
}
