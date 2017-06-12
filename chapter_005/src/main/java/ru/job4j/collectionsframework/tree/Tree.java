package ru.job4j.collectionsframework.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 30.05.2017.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>{

    private Node<E> root;

    private int countAdd = 0;
    private int countNext = 0;

    private int itercount = 0;

    int count = 0;

    Node<E> template;

    Node<E> buff;

    public class Node<E> {
        List<Node<E>> children = new ArrayList<>();
        E value;


        private Node(E value) {
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return value != null ? value.equals(node.value) : node.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        public List<Node<E>> getChildren() {
            return children;
        }

        public E getValue() {
            return value;
        }
    }


    private Node<E> findElement(E value) {
        return this.find(this.root, value);
    }

    private Node<E> find(Node<E> parent, E value) {
        Node<E> result = null;
        if (parent.value.compareTo(value) == 0) {
            result = parent;
        } else if (parent.children != null) {
            for (Node<E> node : parent.children) {
                result = this.find(node, value);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

    public boolean add(E parent, E child) {

        countAdd++;

        if (root == null) {
            buff = template = root = new Node<E>(parent);
            root.children.add(new Node<E>(child));
            return false ;
        }

        if (findElement(parent) != null) {

            findElement(parent).children.add(new Node<>(child));
            return true;
        }
        root.children.add(new Node<>(parent));
        return  false;
    }


    @Override
    public Iterator<E> iterator()  {
        return new myItr();
    }
    private class myItr implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return countAdd > countNext;
        }

        @Override
        public E next() {
            countNext++;
            if (count >= buff.children.size()) {
                count = 0;
                buff = buff.children.get(0);
            }
            if (itercount >= template.children.size()) {

                itercount = 0;
                template = buff.children.get(count++);
            }
            return template.children.get(itercount++).value;
        }


    }
}
