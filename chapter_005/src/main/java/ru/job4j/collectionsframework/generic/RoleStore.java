package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 16.05.2017.
 */
public class RoleStore implements Store<Role>{
    private SimpleArray<Role> store;

    public RoleStore(SimpleArray<Role> store) {
        this.store = store;
    }

    public void add(Role value) {
        store.add(value);
    }
    public void delete(Role value) {
        store.delete(value);
    }
    public void update(int index, Role value) {
        store.update(index, value);
    }
    public Role get(int position) {
        return store.get(position);
    }
}
