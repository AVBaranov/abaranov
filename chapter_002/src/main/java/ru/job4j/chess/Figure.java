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

    /*public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }*/


    /*public Figure clone(Cell dest)
    {
        try {

            return (Figure)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }*/
    abstract public void clone(Cell dest);



}
