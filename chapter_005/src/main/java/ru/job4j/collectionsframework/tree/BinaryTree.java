package ru.job4j.collectionsframework.tree;

import java.util.Iterator;

/**
 * Created by Andrey on 11.06.2017.
 */
public class BinaryTree<E extends Comparable<E>> {

    public Node<E> root;

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
            {
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
            root = newNode;
        } else {
            if (v.compareTo(y.value) <= 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
    }

}
