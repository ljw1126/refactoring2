package com.example.refactoring2.ch12.ex10.part2;

public class Bird {
  private final String name;
  private final String plumage;
  private final SpeciesDelegate speciesDelegate;

  private Bird(BirdDto birdDto) {
    this.name = birdDto.name();
    this.plumage = birdDto.plumage();
    this.speciesDelegate = selectSpeciesDelegate(birdDto);
  }

  private SpeciesDelegate selectSpeciesDelegate(BirdDto birdDto) {
    return switch (birdDto.type()) {
      case "유럽 제비" -> new EuropeanSwallowDelegate();
      case "아프리카 제비" -> new AfricanSwallowDelegate(birdDto);
      case "노르웨이 파랑 앵무" -> new NorwegianBlueParrotDelegate(birdDto);
      default -> new SpeciesDelegate();
    };
  }

  public static Bird from(BirdDto data) {
    return new Bird(data);
  }

  public String name() {
    return name;
  }

  public String plumage() {
    return this.speciesDelegate.plumage(this.plumage);
  }

  public Integer airSpeedVelocity() {
    return this.speciesDelegate.airSpeedVelocity();
  }
}
