package ru.job4j.collectionsframework.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Андрей on 18.05.2017.
 */
public class myiterofiters<T> implements Iterator {

    private int count;

    private ArrayList<Iterator<T>> list;

    public myiterofiters(ArrayList<Iterator<T>> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > count;
    }

    @Override
    public Iterator<T> next() {
        return list.get(count++);
    }
}
