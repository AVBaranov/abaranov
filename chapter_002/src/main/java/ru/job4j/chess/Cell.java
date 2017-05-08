package ru.job4j.chess;

/**
 * Created by Andrey on 13.04.2017.
 */
public class Cell {
    /**
     * variable x.
     */
    private int x;
    /**
     * variable y.
     */
    private int y;
    /**
     * constructor.
     * @param x sets variable x
     * @param y sets variable y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * method returns variable x.
     * @return x
     */
    public int getX() {
        return this.x;
    }
    /**
     * method returns variable y.
     * @return y
     */
    public int getY() {
        return this.y;
    }

}
