package org.learning;

import java.util.Arrays;

public class Calculator {
    public static int add(String numberStr) {
        String[] nums = numberStr.split(",");

        return Arrays.stream(nums)
                .filter(num -> !num.isEmpty())
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
