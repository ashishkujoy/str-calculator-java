package org.learning;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {
    private static Stream<Integer> parseNumbers(String numberStr) {
        return Arrays.stream(numberStr.split("\n"))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Integer::parseInt);
    }
    public static int add(String numberStr) {
        return Calculator.parseNumbers(numberStr)
                .reduce(0, Integer::sum);
    }
}
