package ru.job4j.collectionsframework.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 30.05.2017.
 */
public class Temp<E extends Comparable<E>> {

    private Node<E> root;

    class Node<E> {
        List<Node<E>> children;
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
    }

    private Node<E> findElement(E value) {
        Node<E> temp = root;

        /*if (temp == null) {
            root = temp = new Node<E>(value);
            return root ;
        }*/

        if (temp.children != null) {
            for (int i = 0; i < temp.children.size(); i++) {
                findElement(temp.children.get(i).value);
                if (value.compareTo(temp.children.get(i).value) == 0) {
                    return temp.children.get(i);
                }
            }
        }

        return null;
    }

    public boolean add(E parent, E child) {

        Node<E> temp = root;
        if (temp == null) {
            root = temp = new Node<E>(parent);
            return false ;
        }

        if (findElement(parent) != null) {
            List<Node<E>> list = findElement(parent).children;
            System.out.println(new Node<>(child).value);
            Node<E> node = new Node<>(child);
            //list.add(new Node<>(child));
            list.add(node);
            //findElement(parent).children.add(new Node<>(child));
            return true;
        }
        root.children.add(new Node<>(parent));
        return  false;
    }

}
