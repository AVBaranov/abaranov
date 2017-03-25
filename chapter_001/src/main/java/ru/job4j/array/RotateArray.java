package ru.job4j.array;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class RotateArray {

/**
* method returns turned array.
*@param array - source array
*@return turned array
*/
public int[][] rotate(int[][] array) {
	for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i < j)  {
                    int buf = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = buf;
                }
            }
        }
        int x = 0;
        int y = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length / 2; j++) {

                int buf = array[i][x];
                array[i][x] = array[i][y];
                array[i][y] = buf;
                x++;
                y--;
            }
            x = 0;
            y = array.length - 1;
        }
        return array;
	}
}