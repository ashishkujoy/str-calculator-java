package org.learning;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern customDelimitedNumPattern = Pattern.compile("^//(.+)\\n([\\s\\S]+)$");

    public static Pair<String, String> extractDelimiterAndNumStr(String numberStr) {
        Matcher matcher = customDelimitedNumPattern.matcher(numberStr);
        if (matcher.matches()) {
            return new Pair<>(matcher.group(1), matcher.group(2));
        }
        return new Pair<>(",", numberStr);
    }

    private static Collection<Integer> parseNumbers(String numberStr) {
        Pair<String, String> delimiterAndNumStr = extractDelimiterAndNumStr(numberStr);

        return Arrays.stream(delimiterAndNumStr.second().split("\n"))
                .flatMap(line -> Arrays.stream(line.split(delimiterAndNumStr.first())))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateArguments(Collection<Integer> numbers) throws InvalidNumberException {
        List<Integer> negativeNumbers = numbers.stream()
                .filter(number -> number < 0)
                .toList();

        if (!negativeNumbers.isEmpty()) {
            throw InvalidNumberException.getInstance(negativeNumbers);
        }
    }

    public static int add(String numberStr) throws InvalidNumberException {
        Collection<Integer> numbers = parseNumbers(numberStr);
        validateArguments(numbers);

        return numbers.stream().reduce(0, Integer::sum);
    }
}
