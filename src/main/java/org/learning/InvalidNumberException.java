package org.learning;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(Integer invalidNumber) {
        super(String.format("negative numbers not allowed %s", invalidNumber));
    }
}
