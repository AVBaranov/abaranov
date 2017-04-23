package ru.job4j.chess;

/**
 * Created by Andrey on 17.04.2017.
 */
/*class cl implements Cloneable{
    int x;
    int y;
    public cl(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public cl clone() {
        try {
            return (cl)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }
}*/
public class run {
    public static void main(String[] args) {
        //Figure figure = new Shallop(8,8);
        /*for (int i = 0; i < figure.way(new Cell(8,3)).length; i++) {
            System.out.println(figure.way(new Cell(8,3))[i].getX() + " " + figure.way(new Cell(8,3))[i].getY());
        }*/
        //System.out.println(figure.way(new Cell(8,5))[1].getX());

        //Figure figure1 = new Shallop(1,2);
        Board ob = new Board();
        ob.fillFigure(new Shallop(1,2));
        //ob.fillFigure(new Shallop(1,3));
        ob.move(new Cell(1,2), new Cell(1,5));
    }
}
