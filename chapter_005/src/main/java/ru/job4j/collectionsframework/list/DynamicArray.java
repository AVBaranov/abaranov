package ru.job4j.collectionsframework.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Андрей on 18.05.2017.
 */
public class DynamicArray<E> implements Iterable{

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] values;

    //private static final int DEFAULT_CAPACITY = 10;

    private int itercount = 0;

    public DynamicArray(Object[] array) {
        count = array.length;
        index = array.length;
        this.values = array;
    }

    public DynamicArray() {
        this.values = EMPTY_ELEMENTDATA;
    }

    int index = 0;

    int count = 0;

    public void add(E value) {
        count++;
        if (values.length <= count) {
            int temp = values.length + 1;
           values = Arrays.copyOf(values, temp);
        }
        values[index++] = value;
    }

    public E get(int i) {
        if (i >= index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) values[i];
    }

    public int size() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new myItr();
    }
    private class myItr implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return values.length != itercount;
        }

        @Override
        public E next() {
            return (E) values[itercount++];
        }
    }
}
