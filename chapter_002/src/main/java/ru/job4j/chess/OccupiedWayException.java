package ru.job4j.chess;

/**
 * Created by Andrey on 20.04.2017.
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String str) {
        super(str);
    }
}
