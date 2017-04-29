package ru.job4j.chess;

import java.util.*;

/**
 * Created by Andrey on 17.04.2017.
 */

public class run {
    public static void main(String[] args) {


        run obs = new run();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println(obs.add(linkedList, "string", 10000));
        System.out.println(obs.add(treeSet, "string", 10000));
        System.out.println(obs.add(arrayList, "string", 10000));
        System.out.println();
        System.out.println(obs.delete(linkedList, 1000));
        //System.out.println(obs.delete(treeSet, 100));
        System.out.println(obs.delete(arrayList, 1000));
        //System.out.println(linkedList.get(100));

        //obs.add(arrayList, "string", 10000);



    }
    int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int buf = array[i];
                    array[i] = array[j];
                    array[j] = buf;
                }
            }
        }
        return array;
    }
    public long add(Collection<String> collection, String line, int amount) {
        char s = 'a';
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            line = line +s;
            //System.out.println(str);
            collection.add(line);
            s = (char)(s + 1);
        }
        long fn = System.nanoTime();
        return fn - st;
    }
    public long delete(Collection<String> collection, int amount) {
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(0);
        }
        long fn = System.nanoTime();
        return fn - st;
    }

}
