package ru.job4j.collectionsframework.iterator;

import java.util.Iterator;

/**
 * Created by Андрей on 12.05.2017.
 */
public class DoubleArray implements Iterator {
    private final int[][] values;
    private int index = 0;
    private int index2 = 0;

    public DoubleArray(int[][] values) {
        this.values = values;
    }

    public Object next() {
        if (index2 == values[index].length) {
            index++;
            index2 = 0;
        }
        return values[index][index2++];
    }

    public boolean hasNext() {
        return values.length > index && values[index].length > index2;
    }
}
