package com.example.refactoring2.ch12.ex11;

import java.util.Set;

public class CatalogItem {
    protected final Long id;
    protected final String title;
    protected final Set<String> tags;

    public CatalogItem(Long id, String title, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }
}
