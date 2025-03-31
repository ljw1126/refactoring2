package com.example.refactoring2.ch11.ex13;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import org.junit.jupiter.api.Test;

class ResourcePoolTest {

  @Test
  void getTestWhenEmptyResourcePool() {
    ResourcePool resourcePool = new ResourcePool();

    Resource actual = resourcePool.get();

    assertThat(actual).isEqualTo(new Resource("dummy"));
  }

  @Test
  void getTestWhenExistResourcePool() {
    Deque<Resource> available = new ArrayDeque<>();
    for (int i = 0; i < 5; i++) {
      available.push(new Resource(String.valueOf(i)));
    }

    ResourcePool resourcePool = new ResourcePool(available, new ArrayList<>());

    Resource actual = resourcePool.get();

    assertThat(actual).isEqualTo(new Resource("4"));
  }
}
