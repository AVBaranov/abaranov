package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 15.05.2017.
 */
public class UserStore<T extends Base> implements Store {
    private SimpleArray<T> store;
    public void add(T value) {
        store.add(value);
    }
    public void delete(T value) {
        store.delete(value);
    }
    public void update(int index, T value) {
        store.update(index, value);
    }
    public T get(int position) {
        return store.get(position);
    }

}
