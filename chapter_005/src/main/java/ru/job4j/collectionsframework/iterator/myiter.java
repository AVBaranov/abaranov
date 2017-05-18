package ru.job4j.collectionsframework.iterator;
import java.util.*;
/**
 * Created by Андрей on 15.05.2017.
 */
public class myiter<T> implements Iterator {
    private List<T> list = new ArrayList<T>();
    private int count;

    public myiter(List<T> list) {
        this.list = list;
    }

    public myiter(Iterator<T> it) {
        while (it.hasNext()) {
            this.list.add(it.next());
        }
    }

    @Override
    public boolean hasNext() {
        return list.size() > count;
    }

    @Override
    public T next() {
        return list.get(count++);
    }
}
