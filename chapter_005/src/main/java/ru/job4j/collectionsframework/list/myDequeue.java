package ru.job4j.collectionsframework.list;

/**
 * Created by Andrey on 21.05.2017.
 */
public class myDequeue<E> {
    private Node<E> last;

    private Node<E> first;

    private int size = 0;

    public myDequeue() {
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
        else
            f.prev = newNode;
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

}
