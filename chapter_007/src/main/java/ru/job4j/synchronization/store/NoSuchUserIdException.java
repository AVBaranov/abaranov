package ru.job4j.synchronization.store;

/**
 * Created by Andrey on 03.09.2017.
 */
public class NoSuchUserIdException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public NoSuchUserIdException(String str) {
        super(str);
    }
}
