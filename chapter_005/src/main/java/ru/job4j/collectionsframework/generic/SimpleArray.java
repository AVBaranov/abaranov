package ru.job4j.collectionsframework.generic;
import java.util.*;
/**
 * Created by Андрей on 15.05.2017.
 */
public class SimpleArray<E> {
    private final List<E> list;

    public SimpleArray() {
        this.list = new ArrayList<E>();
}
    public void add(E value) {
        this.list.add(value);
    }
    public E get(int position) {
        return this.list.get(position);
    }
    public void delete(E value) {
        this.list.remove(value);
    }
    public void update(int index, E value) {
        this.list.add(index, value);
    }

}
