package com.example.refactoring2.ch09.ex1;

public class HaggisUtils {
  private HaggisUtils() {}

  public static double distanceTravelled(Scenario scenario, int time) {
    double primaryAcceleration = scenario.primaryForce() / scenario.mass(); // 가속도(a) = 힘(F) / 질량(m)
    int primaryTime = Math.min(time, scenario.delay());
    double result = 0.5 * primaryAcceleration * primaryTime * primaryTime; // 전파된 거리
    int secondaryTime = time - scenario.delay();
    if (secondaryTime > 0) { // 두 번째 힘을 반영해 다시 계산
      double primaryVelocity = primaryAcceleration * scenario.delay();
      double secondaryAcceleration =
          (scenario.primaryForce() + scenario.secondaryForce()) / scenario.mass();
      result +=
          primaryVelocity * secondaryTime
              + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime;
    }

    return result;
  }
}
