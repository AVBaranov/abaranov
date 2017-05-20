package ru.job4j.collectionsframework.generic;

/**
 * Created by Andrey on 20.05.2017.
 */
abstract public class BaseStore implements Store<Base> {
    private SimpleArray<Base> store;

    public BaseStore(SimpleArray<Base> store) {
        this.store = store;
    }

    public void add(Base value) {
        store.add(value);
    }
    public void delete(Base value) {
        store.delete(value);
    }
    public void update(int index, Base value) {
        store.update(index, value);
    }
    public Base get(int position) {
        return store.get(position);
    }
}
