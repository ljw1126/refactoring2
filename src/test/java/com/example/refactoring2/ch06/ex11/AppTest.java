package com.example.refactoring2.ch06.ex11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final String sampleJsonData = """
    [
        {"status": "ready"},
        {"status": "shipped"},
        {"status": "ready"}
    ]
    """;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @DisplayName("빈 문자열 배열을 입력하면 예외를 출력한다")
    @Test
    void emptyStringArray() {
        App.main(new String[] {});
        assertThat(errContent.toString().trim()).isEqualTo("파일명을 입력하세요");
    }

    @DisplayName("-r 옵션이 있으면, ready 상태의 주문 수를 출력한다")
    @Test
    void printOrderCountWithOption() throws IOException {
        Path tempFile = createTempJsonFile(sampleJsonData);
        App.main(new String[] {"-r", tempFile.toString()});

        assertThat(outContent.toString().trim()).isEqualTo("2");
    }

    @DisplayName("-r 옵션이 없으면 Order 배열의 길이를 출력한다")
    @Test
    void printOrderCountWithoutOption() throws IOException {
        Path tempFile = createTempJsonFile(sampleJsonData);
        App.main(new String[] {tempFile.toString()});

        assertThat(outContent.toString().trim()).isEqualTo("3");
    }

    private Path createTempJsonFile(String jsonContent) throws IOException {
        Path tempFile = Files.createTempFile("test-orders", ".json");
        Files.write(tempFile, jsonContent.getBytes());
        tempFile.toFile().deleteOnExit(); // JVM 종료될 때 파일이 자동 삭제되도록 예약
        return tempFile;
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
