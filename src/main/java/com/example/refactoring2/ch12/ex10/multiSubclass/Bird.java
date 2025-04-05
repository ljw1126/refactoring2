package com.example.refactoring2.ch12.ex10.multiSubclass;

public class Bird {
    protected final String name;
    protected final String plumage;

    public Bird(String name, String plumage) {
        this.name = name;
        this.plumage = plumage;
    }

    public static Bird from(BirdDto birdDto) {
        return switch (birdDto.type()) {
            case "유럽 제비" -> new EuropeanSwallow(birdDto);
            case "아프리카 제비" -> new AfricanSwallow(birdDto);
            case "노르웨이 파랑 앵무" -> new NorwegianBlueParrot(birdDto);
            default -> throw new IllegalArgumentException(birdDto.type());
        };
    }

    public String name() {
        return name;
    }

    public String plumage() {
        return this.plumage.isBlank() ? "보통이다" : this.plumage;
    }

    public Integer airSpeedVelocity() {
        return null;
    }

}
