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
        for (int i = 0; i < figures[0].way(dest).length; i++) {
            for (int j = 0; j < figures[0].getAllCells().length; j++) {
                if (figures[0].way(dest)[i].getX() == figures[0].getAllCells()[j].getX() && figures[0].way(dest)[i].getY() == figures[0].getAllCells()[j].getY()) {
                    b = false;
                    throw new OccupiedWayException("occupied way");
                }
            }
        }
        figures[0].add(dest);
        figures[0].position.setX(dest.getX());
        figures[0].position.setY(dest.getY());


        return b;
    }
}
