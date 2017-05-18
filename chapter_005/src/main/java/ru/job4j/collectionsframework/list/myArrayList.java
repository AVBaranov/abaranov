package ru.job4j.collectionsframework.list;

import java.util.Arrays;

/**
 * Created by Андрей on 18.05.2017.
 */
public class myArrayList<E> {

    Object[] values;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public myArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.values = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.values = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public myArrayList() {
        this.values = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    int index = 0;

    int count = 0;

    public void add(E value) {
        count++;
        if (values.length <= count) {
            int temp = values.length + (values.length>>1);
            values = Arrays.copyOf(values, temp);
        }
        values[index++] = value;
    }
}
