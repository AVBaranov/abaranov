package ru.job4j.collectionsframework.iterator;
import java.util.*;
/**
 * Created by Андрей on 15.05.2017.
 */
public class myiter implements Iterator {
    //private final Integer[] values;
    private List<Integer> list = new ArrayList<>();
    private int count;

    public myiter(List<Integer> list) {
        //this.values = values;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        //return values.length > count;
        return list.size() > count;
    }

    @Override
    public Integer next() {
        //return values[count++];

        return list.get(count++);
    }
}
