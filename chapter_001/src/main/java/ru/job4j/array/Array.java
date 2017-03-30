package ru.job4j.array;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Array {

/**
* method returns cut array.
*@param array - source array
*@param length - number of array's elements
*@return cut array
*/
public String[] copyOf(String[] array, int length) {
        String[] newarray = new String[length];
        for (int i = 0; i < newarray.length; i++) {
            newarray[i] = array[i];
        }
        return newarray;
    }
}