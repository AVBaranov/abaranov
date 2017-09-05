package ru.job4j.collectionsframework.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Андрей on 18.05.2017.
 */
@ThreadSafe public class DynamicArray<E> implements Iterable{

    private Object lock = new Object();

    @GuardedBy("lock") private static final Object[] EMPTY_ELEMENTDATA = {};

    @GuardedBy("lock") private Object[] values;

    //private static final int DEFAULT_CAPACITY = 10;

    @GuardedBy("lock") private int itercount = 0;

    public DynamicArray(Object[] array) {
        synchronized (lock) {
            count = array.length;
            index = array.length;
            this.values = array;
        }
    }

    public DynamicArray() {
        synchronized (lock) {
            this.values = EMPTY_ELEMENTDATA;
        }
    }

    @GuardedBy("lock") int index = 0;

    @GuardedBy("lock") int count = 0;

    public void add(E value) {
        synchronized (lock) {
            count++;
            if (values.length <= count) {
                int temp = values.length + 1;
                values = Arrays.copyOf(values, temp);
            }
            values[index++] = value;
        }
    }

    public E get(int i) {
        synchronized (lock) {
            if (i >= index) {
                throw new IndexOutOfBoundsException();
            }
            return (E) values[i];
        }
    }

    public int size() {
        synchronized (lock) {
            return index;
        }
    }

    @Override
    public Iterator<E> iterator() {
        synchronized (lock) {
            return new myItr();
        }
    }
    @ThreadSafe private class myItr implements Iterator<E> {

        @Override
        public boolean hasNext() {
            synchronized (lock) {
                return values.length != itercount;
            }
        }

        @Override
        public E next() {
            synchronized (lock) {
                return (E) values[itercount++];
            }
        }
    }
}
