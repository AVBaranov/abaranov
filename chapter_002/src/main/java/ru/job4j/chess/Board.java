package ru.job4j.chess;

/**
 * Created by Andrey on 18.04.2017.
 */
public class Board {
    private Figure[] figures = new Figure[1];

    boolean move(Cell source, Cell dest) {
        boolean b = true;
        if (source==null) {
            b = false;
            throw new FigureNotFoundException("figure not found");
        }
        try {
            figures[0].way(dest);
        }
        catch(ImpossibleMoveException ime) {
            b = false;
            throw new ImpossibleMoveException("not valid move");
        }


        return b;
    }
}
