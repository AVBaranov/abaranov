package ru.job4j.start;

import java.util.Scanner;
//import ru.job4j.models.Item;

/**
 * Class for input data.
 */
public class ConsoleInput implements Input {
    /**
     * scanner object.
     */
    private Scanner in = new Scanner(System.in);
    /**
     * Method input data.
     * @return input data
     */
    public String ask() {
        return in.next();
    }
    /**
     * Method input data.
     * @param str - message for user
     * @return input data
     */
    public String ask(String str) {
        System.out.print(str);
        return in.next();
    }
    /**
     * Method input data.
     * @return input data
     */
    public long askDate() {
        return in.nextLong();
    }

}


