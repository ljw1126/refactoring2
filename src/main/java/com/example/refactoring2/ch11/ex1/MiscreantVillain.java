package com.example.refactoring2.ch11.ex1;

public class MiscreantVillain {

  private final AlarmService alarmService;

  public MiscreantVillain(AlarmService alarmService) {
    this.alarmService = alarmService;
  }

  public String alertForMiscreant(String[] people) {
    for (String p : people) {
      if (p.equals("조커")) {
        alarmService.setOfAlarms();
        return "조커";
      }

      if (p.equals("사루만")) {
        alarmService.setOfAlarms();
        return "사루만";
      }
    }

    return "";
  }
}
