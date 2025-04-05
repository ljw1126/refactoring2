package com.example.refactoring2.ch12.ex11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Scroll extends CatalogItem {
    private final LocalDate lastCleaned;

    public Scroll(Long id, String title, Set<String> tags, LocalDate lastCleaned) {
        super(id, title, tags);
        this.lastCleaned = lastCleaned;
    }

    public boolean needsCleaning(LocalDate targetDate) {
        int threshold = this.hasTag("revered") ? 700 : 1500;
        return this.daysSinceLastCleaning(targetDate) > threshold;
    }

    private long daysSinceLastCleaning(LocalDate targetDate) {
        return this.lastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
