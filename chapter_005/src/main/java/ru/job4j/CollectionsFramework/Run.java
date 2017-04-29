package ru.job4j.CollectionsFramework;
import java.lang.reflect.Array;
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
        System.out.println("время добавления 10000 элементов в коллекцию LinkedList: " + obs.add(linkedList, "string", 100) + " нс");
        System.out.println("время добавления 10000 элементов в коллекцию ArrayList: " + obs.add(treeSet, "string", 100) + " нс");
        System.out.println("время добавления 10000 элементов в коллекцию TreeSet: " + obs.add(arrayList, "string", 100) + " нс");
        System.out.println();
        System.out.println("время удаления первых 1000 элементов из коллекции LinkedList: " + obs.delete(linkedList, 1000) + " нс");
        //System.out.println(obs.delete(treeSet, 1000));
        System.out.println("время удаления первых 1000 элементов из коллекции ArrayList: " + obs.delete(arrayList, 1000) + " нс");

        Run ob = new Run();
        ConvertArrayList obj = new ConvertArrayList();
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random()*10);
            }
        }
        /*ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                ar.add(array[i][j]);
            }
        }*/



        System.out.println(ob.toList(array));
        ArrayList<Integer> ar = new ArrayList<>();
        ar = (ArrayList<Integer>) obj.toList(array);
        System.out.println(ar.get(0));
        //ar.remove(1);
        ar.remove(4);
        ar.remove(4);

        /*ar.add(1);
        ar.add(4);
        ar.add(1);*/
        /*System.out.println(ar);

        if (ar.size()%Math.sqrt(ar.size()) != 0) {
            System.out.println("kaka");
            while (ar.size()%Math.sqrt(ar.size()) != 0) {
                ar.add(0);
            }
        }
        System.out.println(ar.size());
        System.out.println(ar);
        int[][] mas = new int[(int)Math.sqrt(ar.size())][(int)Math.sqrt(ar.size())];
        System.out.println(mas.length);
        int count = 0;
        for (int i = 0; i < (int)Math.sqrt(ar.size()); i++) {
            for (int j = 0; j < (int)Math.sqrt(ar.size()); j++) {
                mas[i][j] = ar.get(count);
                count++;
            }
        }
        for (int i = 0; i < (int)Math.sqrt(ar.size()); i++) {
            for (int j = 0; j < (int)Math.sqrt(ar.size()); j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }*/

        int[][] arr;
        arr = obj.toArray(ar);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<int[]> obz = new ArrayList<>();
        ArrayList<Integer> obq = new ArrayList<>();
        int[] mass = {1,2,3,4,5,6,7,8,9};
        int[] mass2 = {10,11,12,123,456,2134,58};
        int[] mass3 = {13,14,15,16,17,124,6,58,234};
        obz.add(mass);
        obz.add(mass2);
        obz.add(mass3);
        /*for (int i = 0; i < obz.size(); i++) {
            for (int j = 0; j < obz.get(i).length; j++) {
                System.out.print(obz.get(i)[j] + " ");
                obq.add(obz.get(i)[j]);
            }
            System.out.println();
        }*/
        //System.out.println(obz);
        ArrayList<Integer> obt = new ArrayList<>();
        obt = (ArrayList) obj.convert(obz);
        System.out.println(obt);


    }

    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list) {
        if (list.size()%Math.sqrt(list.size()) != 0) {
            while (list.size()%Math.sqrt(list.size()) != 0) {
                list.add(0);
            }
        }
        int[][] array = new int[(int)Math.sqrt(list.size())][(int)Math.sqrt(list.size())];
        int count = 0;
        for (int i = 0; i < (int)Math.sqrt(list.size()); i++) {
            for (int j = 0; j < (int)Math.sqrt(list.size()); j++) {
                array[i][j] = list.get(count);
                count++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> collectionlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                collectionlist.add(list.get(i)[j]);
            }
        }
        return collectionlist;
    }

}
