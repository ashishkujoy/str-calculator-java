package org.learning;

public class Calculator {
    public static int add(String numberStr) {
        if (numberStr.isEmpty()) return 0;
        return Integer.parseInt(numberStr);
    }
}
