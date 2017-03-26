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
*@return turned array
*/
public int[] back(int[] array) {
        int start = 0;
	int end = array.length - 1;
	for (int i = 0; i < array.length / 2; i++) {
		int buf = array[start];
        	array[start] = array[end];
        	array[end] = buf;
        	start++;
        	end--;
	}
        return array;
    }
}