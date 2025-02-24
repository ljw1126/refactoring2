package com.example.refactoring2.ch06.ex11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println(run(args));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static long run(String[] args) throws IOException {
        if(args.length == 0) throw new RuntimeException("파일명을 입력하세요");
        String fileName = args[args.length - 1];
        return countOrders(args, fileName);
    }

    private static long countOrders(String[] args, String fileName) throws IOException {
        File input = Paths.get(fileName).toFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);
        if(Stream.of(args).anyMatch(arg -> "-r".equals(arg))) {
            return Stream.of(orders)
                    .filter(o -> "ready".equals(o.status()))
                    .count();
        } else {
            return orders.length;
        }
    }
}
