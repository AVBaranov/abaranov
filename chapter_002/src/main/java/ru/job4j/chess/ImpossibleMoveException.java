package ru.job4j.chess;

/**
 * Created by Andrey on 14.04.2017.
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * constructor for class RuntimeException.
     * @param message exception message
     */
    public ImpossibleMoveException(String message) {
        super(message);
        }
    }

