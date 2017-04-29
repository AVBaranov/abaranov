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
    public int[][] toArray(List<Integer> list) {
        if (list.size()%Math.sqrt(list.size()) != 0) {
            while (list.size()%Math.sqrt(list.size()) != 0) {
                list.add(0);
            }
        }
        int[][] array = new int[(int)Math.sqrt(list.size())][(int)Math.sqrt(list.size())];
        int count = 0;
        for (int i = 0; i < (int)Math.sqrt(list.size()); i++) {
            for (int j = 0; j < (int)Math.sqrt(list.size()); j++) {
                array[i][j] = list.get(count);
                count++;
            }
        }
        return array;
    }
}
