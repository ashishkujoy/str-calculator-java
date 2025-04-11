package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void sumOfEmptyString() throws InvalidNumberException {
        int sum = Calculator.add("");
        assertEquals(0, sum);
    }

    @Test
    void sumOfSingleNumber() throws InvalidNumberException {
        int sum = Calculator.add("1");
        assertEquals(1, sum);
    }

    @Test
    void sumOfTwoCommaSeparatedNumbers() throws InvalidNumberException {
        int sum = Calculator.add("1,2");
        assertEquals(3, sum);
    }

    @Test
    void sumOfMultipleCommaSeparatedNumbers() throws InvalidNumberException {
        int sum = Calculator.add("1,2,5");
        assertEquals(8, sum);
    }

    @Test
    void sumOfCustomDelimitedNumbers() throws InvalidNumberException {
        int sum = Calculator.add("1,2,5");
        assertEquals(8, sum);
    }

    @Test
    void sumOfNumbersContainingNewLine() throws InvalidNumberException {
        int sum = Calculator.add("1\n2,5\n7");
        assertEquals(15, sum);
    }

    @Test
    void sumOfNumbersContainingWhitespaceCharacters() throws InvalidNumberException {
        int sum = Calculator.add("1  \n2 ,5\n7");
        assertEquals(15, sum);
    }

    @Test
    void sumOfNumberContainingSingleNegativeNumber() {
        InvalidNumberException exception = assertThrows(InvalidNumberException.class, () -> Calculator.add("1,-2,5"));
        assertEquals("negative numbers not allowed -2", exception.getMessage());
    }

    @Test
    void sumOfNumberContainingMultipleNegativeNumbers() {
        InvalidNumberException exception = assertThrows(InvalidNumberException.class, () -> Calculator.add("1,-2,-5"));
        assertEquals("negative numbers not allowed -2,-5", exception.getMessage());
    }
}
