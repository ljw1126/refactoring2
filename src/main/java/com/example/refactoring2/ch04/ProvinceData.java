package com.example.refactoring2.ch04;

import java.util.List;

public record ProvinceData(String name, List<ProducerDto> producers, int demand, int price) {
}
