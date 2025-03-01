package com.example.refactoring2.ch07.ex6;

public class TrackingInformation {
    private String shippingCompany; // 배송 회사
    private String trackingNumber; // 추적 번호

    public TrackingInformation(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String display() {
        return String.format("%s: %s", this.shippingCompany, this.trackingNumber);
    }
}
