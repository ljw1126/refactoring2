package com.example.refactoring2.ch10.ex1;

import java.time.LocalDate;

public record Plan(
    LocalDate summerStart,
    LocalDate summerEnd,
    double summerRate,
    double regularRate,
    int regularServiceCharge) {}
