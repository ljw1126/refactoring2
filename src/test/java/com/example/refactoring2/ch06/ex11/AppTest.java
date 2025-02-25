package com.example.refactoring2.ch06.ex11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppTest {

    private final String sampleJsonData = """
    [
        {"status": "ready"},
        {"status": "shipped"},
        {"status": "ready"}
    ]
    """;

    @DisplayName("빈 문자열 배열을 입력하면 예외를 출력한다")
    @Test
    void emptyStringArray() {
        assertThatThrownBy(() -> App.run(new String[] {}))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("파일명을 입력하세요");
    }

    @DisplayName("-r 옵션이 있으면, ready 상태의 주문 수를 출력한다")
    @Test
    void runWithOption() throws IOException {
        Path tempFile = createTempJsonFile(sampleJsonData);

        long actual = App.run(new String[] {"-r", tempFile.toString()});

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("-r 옵션이 없으면 Order 배열의 길이를 출력한다")
    @Test
    void runWithoutOption() throws IOException {
        Path tempFile = createTempJsonFile(sampleJsonData);

        long actual = App.run(new String[] {tempFile.toString()});

        assertThat(actual).isEqualTo(3);
    }

    private Path createTempJsonFile(String jsonContent) throws IOException {
        Path tempFile = Files.createTempFile("test-orders", ".json");
        Files.write(tempFile, jsonContent.getBytes());
        tempFile.toFile().deleteOnExit(); // JVM 종료될 때 파일이 자동 삭제되도록 예약
        return tempFile;
    }

}
