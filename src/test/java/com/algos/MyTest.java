package com.algos;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MyTest {

    @Test
    public void test() {
        int[] values = {1, 5, 6};
        assertThat(quickSort(values)).isEqualTo(values);

    /*Collection<String> maList = Arrays.asList("un", "deux", "loldeux", "lol", "lol");
    List<String> lol = maList.stream()
      .filter(s -> s.startsWith("lol"))
      .distinct()
      .collect(Collectors.toList());
    System.out.println(lol);*/
    }

    private int[] quickSort(int[] values) {
        return values;
    }
}
