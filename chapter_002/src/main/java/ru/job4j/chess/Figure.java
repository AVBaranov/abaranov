package ru.job4j.chess;

/**
 * Created by Andrey on 13.04.2017.
 */
abstract public class Figure /*implements Cloneable*/{
    /*final*/ Cell position;
    Figure(int x, int y) {
        Cell poss = new Cell(x, y);
        this.position = poss;
    }
    abstract public Cell[] way(Cell dist);

    abstract public void clone(Cell dest);



}
