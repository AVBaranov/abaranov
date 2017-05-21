package ru.job4j.collectionsframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Андрей on 19.05.2017.
 */
public class Linkedlist<E> implements Iterable<E>{

    private Node<E> last;

    private Node<E> first;

    private Node<E> iternext;

    private int size = 0;

    private int itercount = 0;

    public Linkedlist() {
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

        public E getItem() {
            return item;
        }
    }

    public void add(E e) {
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
    }

    public E get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("out of linkedlist bounds");
        }
        return node(index).item;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        private Node<E> lastReturned;

        public boolean hasNext() {
            return itercount < size;
        }

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

}
