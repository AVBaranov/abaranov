package ru.job4j.collectionsframework.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Андрей on 22.05.2017.
 */
public class ArraySet<E> implements Iterator<E> {
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] values;

    private int index = 0;

    private int count = 0;

    private int itercount = 0;

    public ArraySet() {
        this.values = EMPTY_ELEMENTDATA;
    }

    public boolean add(E value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return false;
            }
        }
        count++;
        if (values.length <= count) {
            int temp = values.length + 1;
            values = Arrays.copyOf(values, temp);
        }
        values[index++] = value;
        return true;
    }

    @Override
    public boolean hasNext() {
        return values.length > itercount;
    }

    @Override
    public E next() {
        return (E) values[itercount++];
    }
}
