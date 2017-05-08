package ru.job4j.chess;

/**
 * Created by Andrey on 18.04.2017.
 */
public class Board {
    /**
     * Array of figures.
     */
    private Figure[] figures = new Figure[2];
    /**
     * method fills array of figures.
     * @param figure - additing figure
     */
    public void fillFigure(Figure figure) {
        this.figures[0] = new Shallop(figure.getPosition().getX(), figure.getPosition().getY());
        this.figures[1] = new Shallop(figure.getPosition().getX(), figure.getPosition().getY());
    }
    /**
     * temporary figure.
     */
    private Figure buffer;
    /**
     * method moves figure.
     * @param source - source position
     * @param dest - destenation position
     * @return true or false
     */
    boolean move(Cell source, Cell dest) {
        boolean b = true;
        boolean bool = true;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && source.getX() == figures[i].getPosition().getX() && source.getY() == figures[i].getPosition().getY()) {
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
        } catch (ImpossibleMoveException ime) {
            b = false;
            throw new ImpossibleMoveException("not valid move");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < figures.length; j++) {
                if (array[i].getX() == figures[j].getPosition().getX() && array[i].getY() == figures[j].getPosition().getY() && (array[i].getX() != buffer.getPosition().getX() || array[i].getY() != buffer.getPosition().getY())) {
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
