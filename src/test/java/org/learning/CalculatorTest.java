package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void sumOfEmptyString() {
        int sum = Calculator.add("");
        assertEquals(0, sum);
    }
}
