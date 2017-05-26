package ru.job4j.collectionsframework.map;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Андрей on 26.05.2017.
 */
public class Hashmap<K,V> {

    private Entry<K,V>[] table;

    private int count = 0;

    public int size() {
        return count;
    }
    private static class Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }
    }

    public int hashCode() {
        int h = 0;
        if (count == 0) {
            return h;
        }
        Entry<K,V>[] tab = table;
        for (Entry<K,V> entry : tab) {
            while (entry != null) {
                h += entry.hashCode();
                entry = entry.next;
            }
        }
        return h;
    }

    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<K,V> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {

        if (count >= table.length) {
            int temp = table.length + 1;
            table = Arrays.copyOf(table, temp);
        }
        Entry<K,V> tab[] = table;

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        Entry<K,V> e = (Entry<K,V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }

    public synchronized V get(Object key) {
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?,?> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V)e.value;
            }
        }
        return null;
    }

}
