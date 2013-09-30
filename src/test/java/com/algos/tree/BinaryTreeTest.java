package com.algos.tree;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeTest {

	@Test
	public void testGet() throws Exception {
		BinaryTree<String, String> tree = new BinaryTree<>();
		assertThat(tree.size()).isEqualTo(0);
		assertThat(tree.get("nawak")).isNull();

		tree.put("root", "rootvalue");
		assertThat(tree.size()).isEqualTo(1);
		assertThat(tree.get("nawak")).isNull();
		assertThat(tree.get("root")).isEqualTo("rootvalue");

		tree.put("sub", "subvalue");
		assertThat(tree.size()).isEqualTo(2);
		assertThat(tree.get("sub")).isEqualTo("subvalue");

		BinaryTree.print(tree);
	}
}
