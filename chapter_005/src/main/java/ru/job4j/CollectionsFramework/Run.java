package ru.job4j.CollectionsFramework;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by Andrey on 29.04.2017.
 */
class Car {
    private double enginecapacity;
    private int weight;
    private String color;
    private int power;
    public Car(double enginecapacity, int weight, String color, int power) {
        this.enginecapacity = enginecapacity;
        this.color = color;
        this.power = power;
        this.weight = weight;
    }
    public String showAll() {
        return this.enginecapacity + "\n" + this.color + "\n" + this.power + "\n" + this.weight + "\n";
    }
}


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
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(0,1);
        ar.add(1,2);
        ar.add(2,3);
        ar.add(3,4);
        ar.add(4,5);
        int[][] arr = new int[2][3];
        arr = obj.toArray(ar, 2);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car(1.6, 1200, "black", 123));
        list.add(new Car(2.0, 1400, "black", 140));
        for (Car car : list) {
            System.out.println(car.showAll());
        }
        HashMap<String, Double> hm = new HashMap<>();
        HashMap<String, Double> hm2 = new HashMap<>();
        HashMap<String, Double> hm3 = new HashMap<>();
        hm2.put("loh", 100.0);
        hm2.put("dibil", 10.0);
        hm2.put("penek", 11.0);
        hm2.put("chelovekoid", 100.0);
        hm.put("loh", 100.0);
        hm.put("dibil", 10.0);
        hm.put("penek", 11.0);
        hm.put("chelovekoid", 100.0);
        Set<Map.Entry<String, Double>> set = hm.entrySet();
        System.out.println(hm.containsKey("lohh"));
        System.out.println(hm.equals(hm2));
        System.out.println(hm.hashCode());
        System.out.println(hm3.isEmpty());
        for (Map.Entry<String, Double> suka : set) {
            System.out.print(suka.getKey() + " : ");
            System.out.println(suka.getValue());
        }
        hm.put("loh",1000000.0);
        for (Map.Entry<String, Double> suka : set) {
            System.out.print(suka.getKey() + " : ");
            System.out.println(suka.getValue());
        }

        User user = new User(11, "mouse", "mouseland");
        User user2 = new User(1112, "fish", "fishland");
        User user3 = new User(11234, "volf", "volfland");

        List<User> ls = new ArrayList<>();
        ls.add(user);
        ls.add(user2);
        ls.add(user3);
        HashMap<Integer, User> hash = new HashMap<>();
        Iterator<User> it = ls.iterator();
        int i = 0;
        /*while(it.hasNext()) {
            hash.put(i, it.next());
            i++;
        }*/
        /*for (User l : ls) {
            hash.put(l.getId(), l);
        }*/
        //hash = ob.process(ls);
        UserConvert us = new UserConvert();
        hash = us.process(ls);
        Set<Map.Entry<Integer, User>> sets = hash.entrySet();
        for (Map.Entry<Integer, User> suka : sets) {
            System.out.print(suka.getKey() + " : ");
            System.out.println(suka.getValue());
        }
        ArrayList<Integer> a = new ArrayList<>();


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

    public int[][] toArray(List<Integer> list, int rows) {
        while (list.size() % rows != 0) {
            list.add(0);
        }
        Iterator<Integer> iter = list.iterator();
        int[][] array = new int[rows][list.size()/rows];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < list.size()/rows; j++) {
                //array[i][j] = list.get(count);
                array[i][j] = iter.next();
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

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hash = new HashMap<>();
        for (User ls : list) {
            hash.put(ls.getId(), ls);
        }
        return hash;
    }
}
