package com.example.refactoring2.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProvinceTest {

    private Province province;

    @BeforeEach
    void setUp() {
        province = Province.from(createSampleProvinceData());
    }

    @Test
    void shortFall() {
        assertThat(province.shortFall()).isEqualTo(5);
    }

    @Test
    void profit() {
        assertThat(province.profit()).isEqualTo(230);
    }

    @Test
    void changeProduction() {
        List<Producer> producers = province.getProducers();
        producers.get(0).setProduction(20);

        assertThat(province.shortFall()).isEqualTo(-6);
        assertThat(province.profit()).isEqualTo(292);
    }

    @Test
    void zeroDemand() {
        province.setDemand(0);

        assertThat(province.shortFall()).isEqualTo(-25);
        assertThat(province.profit()).isEqualTo(0);
    }

    @Test
    void negativeDemand() {
        province.setDemand(-1);

        assertThat(province.shortFall()).isEqualTo(-26);
        assertThat(province.profit()).isEqualTo(-10);
    }

    @Test
    void noProducers() {
        Province noProducers = Province.from(new ProvinceData("No producers", new ArrayList<>(), 30, 20));

        assertThat(noProducers.shortFall()).isEqualTo(30);
        assertThat(noProducers.profit()).isEqualTo(0);
    }

    private static ProvinceData createSampleProvinceData() {
        List<ProducerDto> producerDtos = new ArrayList<>();
        producerDtos.add(new ProducerDto("Byzantium", 10, 9));
        producerDtos.add(new ProducerDto("Attalia", 12, 10));
        producerDtos.add(new ProducerDto("Sinope", 10, 6));

        return new ProvinceData("Asia", producerDtos, 30, 20);
    }
}
