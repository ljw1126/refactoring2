package com.example.refactoring2.ch09.ex1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScenarioTest {

  @Test
  void create() {
    double givenPrimaryForce = 1.0;
    double givenMass = 2.0;
    int givenDelay = 3;
    double givenSecondaryForce = 4.0;

    Scenario scenario = new Scenario(givenPrimaryForce, givenMass, givenDelay, givenSecondaryForce);

    assertThat(scenario.primaryForce()).isEqualTo(givenPrimaryForce);
    assertThat(scenario.mass()).isEqualTo(givenMass);
    assertThat(scenario.delay()).isEqualTo(givenDelay);
    assertThat(scenario.secondaryForce()).isEqualTo(givenSecondaryForce);
  }
}
