package ru.job4j.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 06.09.2017.
 */
public class SimpleQueue<E> {

    private List<E> list = new ArrayList<E>();

    public void add(E value) {
        this.list.add(value);
    }

    public E get() {
        E buff = this.list.get(0);
        this.list.remove(0);
        return buff;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
