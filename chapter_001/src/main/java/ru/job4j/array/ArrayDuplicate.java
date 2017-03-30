package ru.job4j.array;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class ArrayDuplicate {

/**
* method returns array without duplicates.
*@param array - source array
*@return sorted array without duplicates
*/
public String[] remove(String[] array) {
        boolean b;
        String[] newarray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            b = true;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i].equals(array[j])) {
                    b = false;
                }
            }
            if (b) {
                newarray[i] = array[i];
            }
            if (!b) {
                newarray[i] = "x";
            }
        }
        for (int i = 0; i < newarray.length; i++) {
            for (int j = i + 1; j < newarray.length; j++) {
                if (newarray[i].equals("x")) {
                    String buf = newarray[i];
                    newarray[i] = newarray[j];
                    newarray[j] = buf;
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < newarray.length; i++) {
            if (newarray[i].equals("x")) {
                counter++;
            }
        }
        int length = array.length - counter;
        Array obs = new Array();
        return obs.copyOf(newarray, length);
    }
}