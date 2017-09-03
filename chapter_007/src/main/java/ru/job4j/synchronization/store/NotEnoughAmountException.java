package ru.job4j.synchronization.store;

/**
 * Created by Andrey on 03.09.2017.
 */
public class NotEnoughAmountException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public NotEnoughAmountException(String str) {
        super(str);
    }
}
