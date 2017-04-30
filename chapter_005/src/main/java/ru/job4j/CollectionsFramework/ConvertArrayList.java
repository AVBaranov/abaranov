package ru.job4j.CollectionsFramework;

import java.util.*;

/**
 * Created by Andrey on 29.04.2017.
 */
public class ConvertArrayList {

    /**
     * Method converts array to collection.
     * @param array - input array
     * @return collection
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Method converts collection to array.
     * @param list - input collection
     * @return array
     */
    public int[][] toArray(List<Integer> list, int rows) {

        while (list.size() % rows != 0) {
            list.add(0);
        }
        int[][] array = new int[rows][list.size()/rows];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < list.size()/rows; j++) {
                array[i][j] = list.get(count);
                count++;
            }
        }
        return array;
    }

    /**
     * Method converts collection of arrays to collection of Integer.
     * @param list - input collection of arrays
     * @return collection of Integer
     */
    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> collectionlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                collectionlist.add(list.get(i)[j]);
            }
        }
        return collectionlist;
    }
}
