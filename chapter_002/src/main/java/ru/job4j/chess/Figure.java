package ru.job4j.chess;

/**
 * Created by Andrey on 13.04.2017.
 */
abstract /*public*/ class Figure /*implements Cloneable*/ {
    /**
     * position.
     */
    /*final*/ private Cell position;
    /**
     * constructor.
     * @param x sets variable x
     * @param y sets variable y
     */
    Figure(int x, int y) {
        Cell poss = new Cell(x, y);
        this.position = poss;
    }
    /**
     * method returns way.
     * @param dist - cell for move
     * @return way
     */
    abstract /*public*/ Cell[] way(Cell dist);
    /**
     * method clones cell.
     * @param dest - cell for clone
     */
    abstract /*public*/ void clone(Cell dest);
    /**
     * method returns position.
     * @return position
     */
    public Cell getPosition() {
        return position;
    }
    /**
     * method sets position.
     * @param position - cell's position
     */
    public void setPosition(Cell position) {
        this.position = position;
    }
}
