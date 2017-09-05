package ru.job4j.synchronization.store;

/**
 * Created by Андрей on 05.09.2017.
 */
public class NoSuchExpansionException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public NoSuchExpansionException(String str) {
        super(str);
    }
}
