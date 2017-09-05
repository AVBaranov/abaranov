package ru.job4j.collectionsframework.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Андрей on 19.05.2017.
 */
@ThreadSafe public class Linkedlist<E> implements Iterable<E>{

    private Object lock = new Object();

    @GuardedBy("lock") private Node<E> last;

    @GuardedBy("lock") private Node<E> first;

    @GuardedBy("lock") private Node<E> iternext;

    @GuardedBy("lock") private int size = 0;

    @GuardedBy("lock") private int itercount = 0;

    public Linkedlist() {
    }

    @ThreadSafe private class Node<E> {

        @GuardedBy("lock") Node<E> prev;
        @GuardedBy("lock") Node<E> next;
        @GuardedBy("lock") E item;
        Node(Node<E> prev, E item, Node<E> next) {
            synchronized (lock) {
                this.item = item;
                this.next = next;
                this.prev = prev;
            }
        }
    }

    public void add(E e) {
        synchronized (lock) {
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
    }

    public E get(int index) {
        synchronized (lock) {
            if (!(index >= 0 && index < size)) {
                throw new IndexOutOfBoundsException("out of linkedlist bounds");
            }
            return node(index).item;
        }
    }

    Node<E> node(int index) {
        synchronized (lock) {
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
    }

    private boolean hasCycle(Node first) {
        synchronized (lock) {
            boolean b = false;
            Node<E> temp = first.next;
            while (!temp.item.equals(last.item)) {
                if (/*first.item.equals(Tree.item*/first.equals(temp.next)) {
                    return true;
                }
                temp = temp.next;
            }
            return b;
        }
    }
    public boolean runhasCycle() {
        synchronized (lock) {
            return hasCycle(first);
        }
    }

    @Override
    public Iterator iterator() {
        synchronized (lock) {
            return new Itr();
        }
    }

    @ThreadSafe private class Itr implements Iterator<E> {

        @GuardedBy("lock") private Node<E> lastReturned;

        public boolean hasNext() {
            synchronized (lock) {
                return itercount < size;
            }
        }

        public E next() {
            synchronized (lock) {
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

}
