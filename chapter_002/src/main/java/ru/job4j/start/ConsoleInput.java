package ru.job4j.start;

import java.util.Scanner;
//import ru.job4j.models.Item;

/**
 * Class for input data.
 */
public class ConsoleInput {
    /**
     * scanner object.
     */
    private Scanner in = new Scanner(System.in);
    /**
     * Method input data.
     * @return input data
     */
    String ask() {
        return in.next();
    }
    /**
     * Method input data.
     * @return input data
     */
    long askDate() {
        return in.nextLong();
    }

}


