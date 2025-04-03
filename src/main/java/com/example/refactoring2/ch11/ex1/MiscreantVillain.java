package com.example.refactoring2.ch11.ex1;

public class MiscreantVillain {

  private Alarm alarm;

  public MiscreantVillain(Alarm alarm) {
    this.alarm = alarm;
  }

  public void alertForMiscreant(String[] people) {
    if (!findMiscreant(people).isBlank()) {
      alarm.setOffAlarms();
    }
  }

  public String findMiscreant(String[] people) {
    for (String p : people) {
      if (p.equals("조커")) {
        return "조커";
      }

      if (p.equals("사루만")) {
        return "사루만";
      }
    }

    return "";
  }
}
