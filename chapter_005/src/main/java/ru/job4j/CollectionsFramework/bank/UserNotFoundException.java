package ru.job4j.CollectionsFramework.bank;

/**
 * Created by Andrey on 06.05.2017.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String str) {
        super(str);
    }
}
