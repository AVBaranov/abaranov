package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 15.05.2017.
 */
public class UserStore implements Store<User> {
    private SimpleArray<User> store;

    public UserStore(SimpleArray<User> store) {
        this.store = store;
    }

    public void add(User value) {
        store.add(value);
    }
    public void delete(User value) {
        store.delete(value);
    }
    public void update(int index, User value) {
        store.update(index, value);
    }
    public User get(int position) {
        return store.get(position);
    }

}
