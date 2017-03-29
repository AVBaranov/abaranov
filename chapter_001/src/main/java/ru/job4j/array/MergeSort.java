package ru.job4j.array;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class MergeSort {

/**
* method returns sorted array.
*@param array1 - first array
*@param array2 - second array
*@return sorted array
*/
public int[] mergesort(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i == array1.length) {
                array[k] = array2[j];
                j++;
                continue;
            }
            if (j == array2.length) {
                array[k] = array1[i];
                i++;
                continue;
            }
            if (array1[i] <= array2[j]) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
		}
        }
        return array;
    }
}