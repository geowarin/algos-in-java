package com.algos.tree;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeTest {

	@Test
	public void testGet() throws Exception {
		BinaryTree<Integer, String> tree = new BinaryTree<>();
		assertThat(tree.size()).isEqualTo(0);
		assertThat(tree.get(42)).isNull();

		tree.put(5, "5");
		assertThat(tree.size()).isEqualTo(1);
		assertThat(tree.get(42)).isNull();
		assertThat(tree.get(5)).isEqualTo("5");

		tree.put(6, "6");
		assertThat(tree.size()).isEqualTo(2);
		assertThat(tree.get(6)).isEqualTo("6");

		tree.put(6, "6");
		tree.put(4, "4");
		tree.put(3, "3");
		tree.put(10, "10");
		tree.put(12, "12");
		tree.put(9, "9");
	}
}
