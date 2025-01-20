package com.example.refactoring2.ch01;

import java.text.NumberFormat;
import java.util.Locale;

public class Statement {

    public String statement(Invoice invoice, Plays plays) {
        return renderPlainText(StatementData.create(invoice, plays));
    }

    private String renderPlainText(StatementData data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", data.getCustomer())).append("\n");

        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result.append(String.format("%s: %s %d석\n", performances.getPlayName(), usd(performances.getAmount()), performances.getAudience()));
        }

        result.append(String.format("총액: %s\n", usd(data.getTotalAmount())));
        result.append(String.format("적립 포인트: %d점\n", data.getTotalVolumeCredits()));
        return result.toString();
    }

    public String htmlStatement(Invoice invoice, Plays plays) {
        return renderHtml(StatementData.create(invoice, plays));
    }

    private String renderHtml(StatementData data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("<h1>청구 내역 (고객명: %s)</h1>\n", data.getCustomer()));

        result.append("<table>\n");
        result.append("<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n");
        for(EnrichPerformance performance : data.getEnrichPerformances()) {
            result.append(String.format("<tr><td>%s</td><td>%d석</td>", performance.getPlayName(), performance.getAudience()));
            result.append(String.format("<td>%s</td></tr>\n", usd(performance.getAmount())));
        }
        result.append("</table>\n");

        result.append(String.format("<p>총액: <em>%s</em></p>\n",  usd(data.getTotalAmount())));
        result.append(String.format("<p>적립 포인트: <em>%d점</em></p>\n", data.getTotalVolumeCredits()));
        return result.toString();
    }

    private String usd(int aNumber) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(aNumber / 100);
    }
}
