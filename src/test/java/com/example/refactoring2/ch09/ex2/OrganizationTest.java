package com.example.refactoring2.ch09.ex2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganizationTest {

  @Test
  void create() {
    String givenName = "애크미 구스베리";
    String givenCountry = "GB";

    Organization organization = new Organization(givenName, givenCountry);

    Assertions.assertThat(organization)
        .extracting(Organization::getTitle, Organization::getCountry)
        .containsExactly(givenName, givenCountry);
  }
}
