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
        return countOrders(parseCommandLine(args));
    }

    private static CommandLine parseCommandLine(String[] args) {
        return new CommandLine(args);
    }

    private static long countOrders(CommandLine commandLine) throws IOException {
        File input = Paths.get(commandLine.fileName()).toFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        if(commandLine.onlyCountReady()) {
            return Stream.of(orders)
                    .filter(o -> "ready".equals(o.status()))
                    .count();
        } else {
            return orders.length;
        }
    }

    public static class CommandLine {
        private final String[] args;

        public CommandLine(String[] args) {
            if(args.length == 0) {
                throw new RuntimeException("파일명을 입력하세요");
            }
            this.args = args;
        }

        public String fileName() {
            return this.args[this.args.length - 1];
        }

        public boolean onlyCountReady() {
            return Stream.of(args).anyMatch(arg -> "-r".equals(arg));
        }
    }
}
