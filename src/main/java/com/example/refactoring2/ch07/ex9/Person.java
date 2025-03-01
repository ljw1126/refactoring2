package com.example.refactoring2.ch07.ex9;

import java.util.Arrays;
import java.util.List;

public class Person {

    public String foundPerson(String[] peoples) {
        final List<String> candidate = List.of("Don", "John", "Jane");

        return Arrays.stream(peoples)
                .filter(candidate::contains)
                .findFirst()
                .orElse("");
    }

}
