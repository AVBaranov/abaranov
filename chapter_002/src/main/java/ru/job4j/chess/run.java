package ru.job4j.chess;

/**
 * Created by Andrey on 17.04.2017.
 */
public class run {
    public static void main(String[] args) {
        Figure figure = new Figure(8,8);
        for (int i = 0; i < figure.way(new Cell(8,3)).length; i++) {
            System.out.println(figure.way(new Cell(8,3))[i].getX() + " " + figure.way(new Cell(8,3))[i].getY());
        }
        //System.out.println(figure.way(new Cell(8,5)));
        Cell obs = null;
        if (obs==(null)) {
            System.out.println(obs);
        }

    }
}
