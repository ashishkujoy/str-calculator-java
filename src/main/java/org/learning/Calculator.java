package org.learning;

import static java.lang.Integer.parseInt;

public class Calculator {
    public static int add(String numberStr) {
        if (numberStr.isEmpty()) return 0;
        if (numberStr.contains(",")) {
            String[] nums = numberStr.split(",");
            return parseInt(nums[0]) + parseInt(nums[1]);
        }

        return parseInt(numberStr);
    }
}
