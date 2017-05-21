package ru.job4j.collectionsframework.list;

import java.util.Iterator;

/**
 * Created by Andrey on 21.05.2017.
 */
public class Dequeue<E> implements Iterable<E>{
    private Node<E> last;

    private Node<E> first;

    private Node<E> iternext;

    private int size = 0;

    private int itercount = 0;

    public Dequeue() {
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

    public void push(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else {
            f.prev = newNode;
            iternext = newNode;
        }
        size++;
    }

    public void offer(E e) {
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

    public E poll() {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        final E element = first.item;
        final Node<E> next = first.next;
        //first.item = null;
        //first.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;

        return element;
    }

    public E pollLast() {
        if (last == null) {
            throw new IndexOutOfBoundsException();
        }
        final E element = last.item;
        final Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;

        return element;
    }

}
