package com.example.refactoring2.ch11.ex11;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GpsCalculatorTest {

  @Test
  void calculateTest() {
    Point[] points = new Point[11];
    for (int i = 0; i <= 10; i++) {
      points[i] = new Point(10 * i);
    }

    GpsCalculator gpsCalculator = new GpsCalculator(points);

    double actual = gpsCalculator.calculate();

    assertThat(actual).isEqualTo(0.0);
  }
}
