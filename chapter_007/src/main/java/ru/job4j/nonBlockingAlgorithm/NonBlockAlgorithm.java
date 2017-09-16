package ru.job4j.nonBlockingAlgorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by Andrey on 10.09.2017.
 */


class User {

    String name;

    private int version;

    public User(String name) {
        this.name = name;
    }

    public User(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }
}

public class NonBlockAlgorithm {

    private Map<Integer, User> store;

    public NonBlockAlgorithm() {
        this.store = new ConcurrentHashMap<>();
    }

    public NonBlockAlgorithm(int initialCapacity) {
        this.store = new ConcurrentHashMap<>(initialCapacity);
    }

    public User add(Integer key, User value) {
        return this.store.put(key, value);
    }

    public User delete(Integer key) {
        return this.store.remove(key);
    }

    public User get(int key) {
        return store.get(key);
    }

    private void computeIfPresent(int id, User newUser) {
        for (Map.Entry<Integer, User> value : store.entrySet()) {
            if (value.getKey() == id) {
                if (newUser.getVersion() == value.getValue().getVersion()) {
//                    value.getValue().version++;
                    store.put(id, new User(value.getValue().getVersion() + 1));
                }
                else {
                    throw new OptimisticException("error");
                }
            }
        }
    }

    public void update(int id, User newUser) {
        this.computeIfPresent(id, newUser);
        for (Map.Entry<Integer, User> value : store.entrySet()) {
            if (value.getKey() == id) {
                store.put(id, newUser);
            }
        }
    }

    public static void main(String[] args) {

        NonBlockAlgorithm map = new NonBlockAlgorithm();
        map.add(10, new User("sdrf"));
        map.update(10, new User("sdfgdfhh"));
        System.out.println(map.get(10).getName());
    }

}
