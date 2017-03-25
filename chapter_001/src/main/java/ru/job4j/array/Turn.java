package ru.job4j.array;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Turn {

/**
* method returns turned array.
*@param array - source array
*@param start - index of first array's element
*@param end - index of last array's element
*@return turned array
*/
public int[] back(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int buf = array[start];
        array[start] = array[end];
        array[end] = buf;
        start++;
        end--;
        back(array, start, end);
        return array;
    }
}