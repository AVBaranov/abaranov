package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 15.05.2017.
 */
public interface Store<T extends Base> {
    void add(T value);
    public void delete(T value);
    public void update(int index, T value);
    public T get(int position);

}
