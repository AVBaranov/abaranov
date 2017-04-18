package ru.job4j.chess;

/**
 * Created by Andrey on 13.04.2017.
 */
public class Cell {
    private int x;
    private int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
