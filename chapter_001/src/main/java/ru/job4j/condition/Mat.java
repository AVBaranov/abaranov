package ru.job4j.condition;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Mat {
/**
* method returns number in the selected degree.
*@param i - number
*@param j - degree
*@return number in the selected degree
*/
    static double sqr(double i, int j) {
        if (j == 0) {
	return 1;
	}
        return sqr(i, j - 1) * i;
    }
}
