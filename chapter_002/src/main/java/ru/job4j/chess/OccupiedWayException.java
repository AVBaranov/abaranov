package ru.job4j.chess;

/**
 * Created by Andrey on 20.04.2017.
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * constructor for class RuntimeException.
     * @param str exception message
     */
    public OccupiedWayException(String str) {
        super(str);
    }
}
