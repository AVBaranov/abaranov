package ru.job4j.chess;

//import java.io.FileNotFoundException;

/**
 * Created by Andrey on 23.04.2017.
 */
public class Shallop extends Figure {
    /**
     * constructor.
     * @param x sets variable x
     * @param y sets variable y
     */
    public Shallop(int x, int y) {
        super(x, y);
    }
    /**
     * method returns figure's way.
     * @param dist - destenation cell
     * @return way
     */
    public Cell[] way(Cell dist) {
        int coord1 = getPosition().getX();
        int coord2 = getPosition().getY();
        int count = 0;
        boolean b = false;
        Cell[] array = null;
        // если координата по вертикали не изменяется, то предполагаем что ладья двигается по горизонтали(вправо и влево)
        if (getPosition().getY() == dist.getY()) {
            // считаем размерность массива ячеек для случая когда координата Х текущей позиции фигуры меньше координаты Х ячейки в которую нужно пойти
            if (coord1 < dist.getX()) {
                for (int i = coord1; i <= 8; i++) {
                    if ((coord1 == dist.getX()) && (coord2 == dist.getY())) {
                        b = true;
                        break;
                    }
                    count++;
                    coord1++;
                }
            }
            // считаем размерность массива ячеек для случая когда координата Х текущей позиции фигуры больше координаты Х ячейки в которую нужно пойти
            if (coord1 > dist.getX()) {
                for (int i = coord1; i >= 0; i--) {
                    if ((coord1 == dist.getX()) && (coord2 == dist.getY())) {
                        b = true;
                        break;
                    }
                    count++;
                    coord1--;
                }
            }

            array = new Cell[count];
            coord1 = getPosition().getX();
            // заполняем массив ячееками для случая когда координата Х текущей позиции фигуры меньше координаты Х ячейки в которую нужно пойти
            if (coord1 < dist.getX()) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = new Cell(coord1, coord2);
                    coord1++;
                }
            }
            // заполняем массив ячееками для случая когда координата Х текущей позиции фигуры больше координаты Х ячейки в которую нужно пойти
            if (coord1 > dist.getX()) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = new Cell(coord1, coord2);
                    coord1--;
                }
            }
        }
        if (getPosition().getX() == dist.getX()) {
            if (coord2 < dist.getY()) {
                for (int i = coord2; i <= 8; i++) {
                    if ((coord1 == dist.getX()) && (coord2 == dist.getY())) {
                        b = true;
                        break;
                    }
                    count++;
                    coord2++;
                }
            }
            if (coord2 > dist.getY()) {
                for (int i = coord2; i >= 0; i--) {
                    if ((coord1 == dist.getX()) && (coord2 == dist.getY())) {
                        b = true;
                        break;
                    }
                    count++;
                    coord2--;
                }
            }
            array = new Cell[count];
            coord2 = getPosition().getY();
            if (coord2 < dist.getY()) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = new Cell(coord1, coord2);
                    coord2++;
                }
            }
            if (coord2 > dist.getY()) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = new Cell(coord1, coord2);
                    coord2--;
                }
            }
        }



        if (b) {
            return array;
        }
        throw new ImpossibleMoveException("Impossible move");
    }
    /**
     * method clones cell.
     * @param dest - destenetion cell
     */
    public void clone(Cell dest) {
        this.setPosition(dest);
    }


}
