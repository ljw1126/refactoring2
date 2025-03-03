package com.example.refactoring2.ch07.ex6;

public class Shipment {
    private String shippingCompany; // 배송 회사
    private String trackingNumber; // 추적

    public Shipment(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String display() {
        return String.format("%s: %s", this.shippingCompany, this.trackingNumber);
    }

    public void setShippingCompany(String arg) {
        this.shippingCompany = arg;
    }

    public void setTrackingNumber(String arg) {
        this.trackingNumber = arg;
    }
}
