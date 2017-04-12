package ru.job4j.start;

/**
 * axception class.
 */
public class MenuOutOfBoundsAxception extends RuntimeException {
    /**
     * constructor for class RuntimeException.
     * @param mesage - exception message
     */
    public MenuOutOfBoundsAxception(String mesage) {
        super(mesage);
    }
}
