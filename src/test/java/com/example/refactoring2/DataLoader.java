package com.example.refactoring2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class DataLoader {

    private final ObjectMapper objectMapper;
    private final ClassLoader classLoader;

    public DataLoader(ObjectMapper objectMapper, ClassLoader classLoader) {
        this.objectMapper = objectMapper;
        this.classLoader = classLoader;
    }

    public <T> T getResource(String filePath, TypeReference<T> typeReference) {
        try(InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
            return objectMapper.readValue(inputStream, typeReference);
        }  catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
