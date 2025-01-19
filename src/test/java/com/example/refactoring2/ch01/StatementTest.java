package com.example.refactoring2.ch01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class StatementTest {

    @Test
    void statement() {
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
                "hamlet: $650.00 55석\n" +
                "As You Like It: $580.00 35석\n" +
                "Othello: $500.00 40석\n" +
                "총액: $1,730.00\n" +
                "적립 포인트: 47점\n";

        Statement statement = new Statement();
        String actual = statement.statement(invoice, plays);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void htmlStatement() {
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

        String expected = "<h1>청구 내역 (고객명: BigCo)</h1>\n" +
                "<table>\n" +
                "<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n" +
                "<tr><td>hamlet</td><td>55석</td><td>$650.00</td></tr>\n" +
                "<tr><td>As You Like It</td><td>35석</td><td>$580.00</td></tr>\n" +
                "<tr><td>Othello</td><td>40석</td><td>$500.00</td></tr>\n" +
                "</table>\n" +
                "<p>총액: <em>$1,730.00</em></p>\n" +
                "<p>적립 포인트: <em>47점</em></p>\n";

        Statement statement = new Statement();
        String actual = statement.htmlStatement(invoice, plays);

        assertThat(actual).isEqualTo(expected);
    }
}
