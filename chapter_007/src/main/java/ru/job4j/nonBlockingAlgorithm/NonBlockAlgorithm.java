package ru.job4j.nonBlockingAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrey on 10.09.2017.
 */
public class NonBlockAlgorithm<K, V> {

    int version = 0;

    private Map<K, V> store;

    private Map<K, V> tempstore;

    public NonBlockAlgorithm() {
        this.tempstore = new ConcurrentHashMap<>();
    }

    public NonBlockAlgorithm(int initialCapacity) {
        this.tempstore = new ConcurrentHashMap<>(initialCapacity);
    }

    public V add(K key, V value) {
        return this.tempstore.put(key, value);
    }

    public V delete(K key) {
        return this.tempstore.remove(key);
    }

    public void update() {
        version++;
        for (Map.Entry value : tempstore.entrySet()) {
            store.put((K) value.getKey(), (V) value.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                map.put("k1", "v1");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                map.put("k1", "v2");
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.get("k1"));
    }

}
