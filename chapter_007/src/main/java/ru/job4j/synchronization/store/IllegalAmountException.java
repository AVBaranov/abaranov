package ru.job4j.synchronization.store;

/**
 * Created by Андрей on 04.09.2017.
 */
public class IllegalAmountException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public IllegalAmountException(String str) {
        super(str);
    }
}
