package ru.job4j.chess;

/**
 * Created by Andrey on 17.04.2017.
 */

public class run {
    public static void main(String[] args) {
       
        Board ob = new Board();
        ob.fillFigure(new Shallop(1,2));
        //ob.fillFigure(new Shallop(1,3));
        ob.move(new Cell(1,2), new Cell(1,5));
    }
}
