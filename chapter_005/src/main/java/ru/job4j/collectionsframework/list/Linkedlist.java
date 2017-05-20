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

    private int size = 0;

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

    }

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
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

        return null;
    }

    public Iterator<E> myiterator(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("out of linkedlist bounds");
        }
        return new Itr(index);
    }

    private class Itr implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        Itr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }
    }

}
