package ru.job4j.collectionsframework.tree;

/**
 * Created by Andrey on 28.05.2017.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent, E child);
    //boolean isBinary();
}
