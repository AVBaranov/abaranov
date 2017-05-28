package ru.job4j.collectionsframework.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 28.05.2017.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private List<Node<E>> list;

    int itercount = 0;

    public Tree() {
        this.list = new ArrayList<>();
    }

    class Node<E>
    {
        List<E> children;
        E value;

        public Node(E value, List<E> children) {
            this.value = value;
            this.children = children;
        }
    }

    @Override
    public boolean add(E parent, E child) {
        // проходим по списку деревьев, если находится дерево, корень которого совпадает с параметром parent, добавляем параметр child в список дочерних
        // элементов этого дерева
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).children != null && list.get(i).value.compareTo(parent) == 0) {
                    List<E> temp = list.get(i).children;
                    temp.add(child);
                    list.set(i, new Node<E>(parent, temp));
                    return true;
                }
            }
            // если в списке деревьев нет дерева с корнем parent, то добавляем это дерево и его дочерний элемент в список деревьев
        List<E> ls = new ArrayList<E>();
            ls.add(child);
        list.add(new Node<E>(parent, ls));
        return false;
    }

    public int size()
    {
        return list.size();
    }

    public List<E> getChildren(E parent) {
        List<E> buff = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).value.equals(parent)) {
                buff = list.get(i).children;
            }
        }
        return buff;
    }

    public boolean isBinary() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).children.size() > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new myItr();
    }
    private class myItr implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return list.size() != itercount;
        }

        @Override
        public E next() {
            return  list.get(itercount++).value;
        }
    }

}
