package ru.job4j.chess;

import java.io.FileNotFoundException;

/**
 * Created by Andrey on 18.04.2017.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String str) {
        super(str);
    }
}
