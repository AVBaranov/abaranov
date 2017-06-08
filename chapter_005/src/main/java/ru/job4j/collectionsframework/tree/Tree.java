package ru.job4j.collectionsframework.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 30.05.2017.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>{

    /*private*/public Node<E> root;

    private int itercount = 0;

    public Node<E> getRoot() {
        return this.root;
    }

    public class Node<E> {
        List<Node<E>> children = new ArrayList<>();
        E value;


        public Node(E value) {
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

    /*private Node<E> findElement(E value) {
        Node<E> temp = root;

        if (temp.children != null) {
            for (int i = 0; i < temp.children.size(); i++) {
                findElement(temp.children.get(i).value);
                if (value.compareTo(temp.children.get(i).value) == 0) {
                    return temp.children.get(i);
                }
            }
        }

        return null;
    }*/

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

        Node<E> temp = root;
        if (temp == null) {
            root = temp = new Node<E>(parent);
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
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
