package ru.job4j.collectionsframework.list;

/**
 * Created by Андрей on 19.05.2017.
 */
public class myLinkedList<E> {

    private Node<E> last;

    private Node<E> next;

    private int size = 0;

    public myLinkedList() {
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
}
