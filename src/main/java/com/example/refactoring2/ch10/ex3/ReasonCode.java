package com.example.refactoring2.ch10.ex3;

public enum ReasonCode {
  SEP("퇴사"),
  RET("은퇴"),
  BASIC("기본");

  private String text;

  ReasonCode(String text) {
    this.text = text;
  }
}
