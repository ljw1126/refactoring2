package com.example.refactoring2.ch01;

public class Statement {

    public String statement(Invoice invoice, Plays plays) {
        return renderPlainText(StatementData.create(invoice, plays));
    }

    private String renderPlainText(StatementData data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", data.getCustomer())).append("\n");

        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result.append(String.format("%s: $%d %d석\n", performances.getPlayName(), performances.getAmount() / 100, performances.getAudience()));
        }

        result.append(String.format("총액: $%d\n", data.getTotalAmount() / 100));
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
            result.append(String.format("<td>$%d</td></tr>\n", performance.getAmount() / 100));
        }
        result.append("</table>\n");

        result.append(String.format("<p>총액: <em>$%d</em></p>\n", data.getTotalAmount() / 100));
        result.append(String.format("<p>적립 포인트: <em>%d점</em></p>\n", data.getTotalVolumeCredits()));
        return result.toString();
    }
}
