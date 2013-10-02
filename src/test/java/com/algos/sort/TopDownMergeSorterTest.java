package com.algos.sort;

import org.junit.Test;

public class TopDownMergeSorterTest extends SorterTestCase {
	@Test
	public void testSort() throws Exception {
		testSorter(new TopDownMergeSorter<>());
	}
}
