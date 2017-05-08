package ru.job4j.collectionsframework.bank;

/**
 * Created by Andrey on 06.05.2017.
 */
public class UserNotFoundException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public UserNotFoundException(String str) {
        super(str);
    }
}
