package ru.job4j.chess;

/**
 * Created by Andrey on 13.04.2017.
 */
public class Figure {
    final Cell position;
    Figure(int x, int y) {
        Cell poss = new Cell(x, y);
        this.position = poss;
    }
    int count = 0;
    private Cell[] cells = new Cell[64];
    public Cell[] getAllCells() {
        return this.cells;
    }
    public Cell add(Cell cell) {
        if (cell == null) {
            System.out.println("wrong parametr!");
            return null;
        }
        this.cells[count++] = cell;
        return cell;
    }
    public Cell[] way(Cell dist) {
        int coord1 = position.getX();
        int coord2 = position.getY();
        int count = 0;
        boolean b = false;
        Cell[] array = null;
        // если координата по вертикали не изменяется, то предполагаем что ладья двигается по горизонтали(вправо и влево)
        if (position.getY() == dist.getY()) {
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
            coord1 = position.getX();
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
        if (position.getX() == dist.getX()) {
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
            coord2 = position.getY();
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
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

}
