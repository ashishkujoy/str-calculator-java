package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void sumOfEmptyString() {
        int sum = Calculator.add("");
        assertEquals(0, sum);
    }

    @Test
    void sumOfSingleNumber() {
        int sum = Calculator.add("1");
        assertEquals(1, sum);
    }

    @Test
    void sumOfTwoCommaSeparatedNumbers() {
        int sum = Calculator.add("1,2");
        assertEquals(3, sum);
    }

    @Test
    void sumOfMultipleCommaSeparatedNumbers() {
        int sum = Calculator.add("1,2,5");
        assertEquals(8, sum);
    }

    @Test
    void sumOfCustomDelimitedNumbers() {
        int sum = Calculator.add("1,2,5");
        assertEquals(8, sum);
    }

    @Test
    void sumOfNumbersContainingNewLine() {
        int sum = Calculator.add("1\n2,5\n7");
        assertEquals(15, sum);
    }

    @Test
    void sumOfNumbersContainingWhitespaceCharacters() {
        int sum = Calculator.add("1  \n2 ,5\n7");
        assertEquals(15, sum);
    }
}
