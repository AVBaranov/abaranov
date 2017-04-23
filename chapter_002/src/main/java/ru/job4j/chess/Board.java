package ru.job4j.chess;

/**
 * Created by Andrey on 18.04.2017.
 */
public class Board {
    private Figure[] figures = new Figure[2];

    public void fillFigure(Figure figure) {
        this.figures[0] = new Shallop(figure.position.getX(), figure.position.getY());
        this.figures[1] = new Shallop(figure.position.getX(), figure.position.getY());
    }

    Figure buffer;

    boolean move(Cell source, Cell dest) {
        boolean b = true;
        boolean bool = true;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && source.getX() == figures[i].position.getX() && source.getY() == figures[i].position.getY()) {
                bool = false;
                buffer = figures[i];
            }
        }
        if (bool) {
            b = false;
            throw new FigureNotFoundException("figure not found");
        }
        Cell[] array;
        try {
            array = buffer.way(dest);
        }
        catch(ImpossibleMoveException ime) {
            b = false;
            throw new ImpossibleMoveException("not valid move");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < figures.length; j++) {
                if (array[i].getX() == figures[j].position.getX() && array[i].getY() == figures[j].position.getY() && (array[i].getX() != buffer.position.getX() || array[i].getY() != buffer.position.getY())) {
                    b = false;
                    throw new OccupiedWayException("occupied way");
                }
            }
        }
        if (b) {
            buffer.clone(dest);
        }


        return b;
    }
}
