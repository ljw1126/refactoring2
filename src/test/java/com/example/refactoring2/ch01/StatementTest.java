package com.example.refactoring2.ch01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class StatementTest {

    @Test
    void statement() throws Exception {
        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));
        Invoice invoice = new Invoice("BigCo", performances);

        Map<String, Play> playMap = new HashMap<>();
        playMap.put("hamlet", new Play("hamlet", PlayType.TRAGEDY));
        playMap.put("as-like", new Play("As You Like It", PlayType.COMEDY));
        playMap.put("othello", new Play("Othello", PlayType.TRAGEDY));
        Plays plays = new Plays(playMap);

        String expected = "청구 내역 (고객명: BigCo)\n" +
                "hamlet: $650 55석\n" +
                "As You Like It: $580 35석\n" +
                "Othello: $500 40석\n" +
                "총액: $1730\n" +
                "적립 포인트: 47점\n";

        Statement statement = new Statement();
        String actual = statement.statement(invoice, plays);

        assertThat(actual).isEqualTo(expected);
    }
}
