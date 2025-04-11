package org.learning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Calculator {
    private static Collection<Integer> parseNumbers(String numberStr) {
        return Arrays.stream(numberStr.split("\n"))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateArguments(Collection<Integer> numbers) throws InvalidNumberException {
        Optional<Integer> negativeNumber = numbers.stream().filter(number -> number < 0).findFirst();

        if (negativeNumber.isPresent()) {
            throw new InvalidNumberException(negativeNumber.get());
        }
    }

    public static int add(String numberStr) throws InvalidNumberException {
        Collection<Integer> numbers = parseNumbers(numberStr);
        validateArguments(numbers);

        return numbers.stream().reduce(0, Integer::sum);
    }
}
