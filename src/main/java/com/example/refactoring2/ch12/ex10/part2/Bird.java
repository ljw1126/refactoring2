package com.example.refactoring2.ch12.ex10.part2;

public class Bird {
  protected final String name;
  protected final String plumage;
  protected SpeciesDelegate speciesDelegate;

  public Bird(String name, String plumage) {
    this.name = name;
    this.plumage = plumage;
  }

  public Bird(BirdDto birdDto) {
    this.name = birdDto.name();
    this.plumage = birdDto.plumage();
    this.speciesDelegate = selectSpeciesDelegate(birdDto);
  }

  private SpeciesDelegate selectSpeciesDelegate(BirdDto birdDto) {
    return switch (birdDto.type()) {
      case "유럽 제비" -> new EuropeanSwallowDelegate(this);
      case "아프리카 제비" -> new AfricanSwallowDelegate(birdDto, this);
      case "노르웨이 파랑 앵무" -> new NorwegianBlueParrotDelegate(birdDto, this);
      default -> new SpeciesDelegate(this);
    };
  }

  public static Bird from(BirdDto data) {
    return new Bird(data);
  }

  public String name() {
    return name;
  }

  public String plumage() {
    return this.speciesDelegate.plumage();
  }

  public Integer airSpeedVelocity() {
    return this.speciesDelegate.airSpeedVelocity();
  }
}
