package com.example.refactoring2.ch11.ex13;

import java.util.*;

public class ResourcePool {
  private Deque<Resource> available;
  private List<Resource> allocated;

  public ResourcePool() {
    this(new ArrayDeque<>(), new ArrayList<>());
  }

  public ResourcePool(Deque<Resource> available, List<Resource> allocated) {
    this.available = available;
    this.allocated = allocated;
  }

  public Resource get() {
    Resource result;

    try {
      result = available.pop();
      allocated.add(result);
    } catch (NoSuchElementException e) {
      result = Resource.create();
      allocated.add(result);
    }

    return result;
  }
}
