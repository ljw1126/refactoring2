package com.example.refactoring2.ch01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Invoice invoice = getResource(objectMapper, "ch01/invoices.json", new TypeReference<>() {});
        Map<String, Play> playsMap = getResource(objectMapper, "ch01/plays.json", new TypeReference<>(){});
        Plays plays = new Plays(playsMap);

        Statement statement = new Statement();
        logger.info("{}\n", statement.statement(invoice, plays));
        logger.info("{}\n", statement.htmlStatement(invoice, plays));
    }

    private static <T> T getResource(ObjectMapper objectMapper, String filePath, TypeReference<T> typeReference) {
        ClassLoader classLoader = App.class.getClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
            return objectMapper.readValue(inputStream, typeReference);
        }  catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
