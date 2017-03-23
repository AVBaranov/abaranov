package ru.job4j.loop;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Paint {

/**
* method returns max number.
*@param h - height of the pyramid
*@return pyramid
*/
public String pyramid(int h) {
        StringBuilder obj = new StringBuilder();
        int m = h;
        int n = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m - 1; j++) {
                obj.append(" ");
            }
            for (int j = 0; j < 2 * n - 1; j++) {
                obj.append("^");
            }
            obj.append("\n");
            m--;
            n++;
        }
        return obj.toString();
    }

}