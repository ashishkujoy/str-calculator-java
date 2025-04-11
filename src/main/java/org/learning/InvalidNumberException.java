package org.learning;

import java.util.Collection;
import java.util.stream.Collectors;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(String invalidNumbers) {
        super(String.format("negative numbers not allowed %s", invalidNumbers));
    }

    public static InvalidNumberException getInstance(Collection<Integer> invalidNumbers) {
        String invalidNumbersAsStr = invalidNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return new InvalidNumberException(invalidNumbersAsStr);
    }
}
