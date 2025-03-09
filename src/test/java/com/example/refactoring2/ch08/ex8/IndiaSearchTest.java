package com.example.refactoring2.ch08.ex8;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class IndiaSearchTest {

  @Test
  void acquireDataTest() {
    String input =
        """
office, country, telephone
Chicago, USA, +1 312 373 1000
Beijing, China, +86 4008 900 505
Bangalore, India, +91 80 4064 9570
Porto Alegre, Brazil, +55 31 3079 3550
Chennai, India, +91 44 660 44766
""";

    List<SearchResult> actual = IndiaSearch.acquireData(input);

    assertThat(actual)
        .hasSize(2)
        .containsExactly(
            new SearchResult("Bangalore", "+91 80 4064 9570"),
            new SearchResult("Chennai", "+91 44 660 44766"));
  }
}
