package ru.job4j.start;

//import java.util.Scanner;

/**
 * Interface for input date.
 */
public interface Input {
    /**
     * Method input data.
     * @return input data
     */
    String ask();
    /**
     * Method input data.
     * @param str str
     * @return input data
     */
    String ask(String str);
    /**
     * Method input data.
     * @return input data
     */
    long askDate();
}
