package com.example.refactoring2.ch08.ex1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GpsTrackSummaryTest {

    @Test
    void trackSummaryTest() {
        List<Waypoint> points = List.of(
                new Waypoint(37.7749, -122.4194, 1000), // 샌프란시스코 (시작)
                new Waypoint(34.0522, -118.2437, 4000)  // 로스앤젤레스 (끝)
        );

        TrackSummary actual = GpsTrackSummary.trackSummary(points);

        assertThat(actual.getTotalDistance()).isEqualTo(3000.0, offset(0.1));
        assertThat(actual.getTotalTime()).isEqualTo(559.12, offset(0.1));
        assertThat(actual.getPace()).isEqualTo(0.0894, offset(0.1));
    }
}
