package ru.job4j.collectionsframework.set;

import java.util.Iterator;

/**
 * Created by Андрей on 22.05.2017.
 */
public class LinkedSet<E> implements Iterator<E>{
    private Node<E> last;

    private Node<E> first;

    private Node<E> iternext;

    private int size = 0;

    private int itercount = 0;

    private Node<E> lastReturned;

    public LinkedSet() {
    }

    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E item;
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(E e) {
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            if (x.item.equals(e)) {
                return false;
            }
            x = x.next;
        }

        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
            iternext = newNode;
        }

        else
            l.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean hasNext() {
        return size > itercount;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("out of iterator() bounds");
        }
        lastReturned = iternext;
        iternext = iternext.next;
        itercount++;
        return lastReturned.item;
    }
}
