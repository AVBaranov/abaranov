package ru.job4j.CollectionsFramework;
import java.util.*;
/**
 * Created by Andrey on 29.04.2017.
 */
public class Run {
    public static void main(String[] args) {
        EditCollection obs = new EditCollection();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println("время добавления 10000 элементов в коллекцию LinkedList: " + obs.add(linkedList, "string", 10000) + " нс");
        System.out.println("время добавления 10000 элементов в коллекцию ArrayList: " + obs.add(treeSet, "string", 10000) + " нс");
        System.out.println("время добавления 10000 элементов в коллекцию TreeSet: " + obs.add(arrayList, "string", 10000) + " нс");
        System.out.println();
        System.out.println("время удаления первых 1000 элементов из коллекции LinkedList: " + obs.delete(linkedList, 1000) + " нс");
        //System.out.println(obs.delete(treeSet, 1000));
        System.out.println("время удаления первых 1000 элементов из коллекции ArrayList: " + obs.delete(arrayList, 1000) + " нс");
    }

}
