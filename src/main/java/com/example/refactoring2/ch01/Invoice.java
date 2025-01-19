package com.example.refactoring2.ch01;

import java.util.List;

public record Invoice(String customer, List<Performance> performances) {
}
