package ru.job4j.collectionsframework.tree;

import java.util.Iterator;

/**
 * Created by Andrey on 11.06.2017.
 */
public class BinaryTree<E extends Comparable<E>> implements Iterable<E>{

    public Node<E> root;

    public Node<E> template;

    private Node<E> iternext;

    private int itercount = 0;

    private int count = 0;

    public class Node<E> {
        public E value;
        public Node<E> left, right;

        Node(E value) {
            this.value = value;
        }
    }

    public void add(E v) {
        Node<E> x = root, y = null;
        while (x != null) {
            int cmp = v.compareTo(x.value);
            /*if (cmp == 0) {
                x.value = v;
                return;
            } else*/{
                y = x;
                if (cmp <= 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        Node<E> newNode = new Node<E>(v);
        if (y == null) {
            iternext = root = newNode;
        } else {
            if (v.compareTo(y.value) <= 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
    }

    @Override
    public Iterator<E> iterator()  {
        return new myItr();
    }
    private class myItr implements Iterator<E> {

        private Node<E> lastReturned;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {



            lastReturned = iternext;
            if (count % 2 == 0) {
                iternext = iternext.left;
            } else {
                iternext = iternext.right;
            }

            itercount++;
            count++;
            return lastReturned.value;
        }


    }
}
