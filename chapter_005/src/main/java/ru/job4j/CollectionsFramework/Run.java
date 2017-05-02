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

class comp implements Comparator<String> {
    public int compare(String a, String b) {
        /*String astr, bstr;
        astr = a;
        bstr = b;*/
        return a.compareTo(b);
    }
}


public class Run {
    static class user implements Comparable<user>{
        private String name;
        private Integer age;
        public user(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            user user = (user) o;

            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
        @Override
        public int compareTo(user o) {
            //return this.name.compareTo(o.name);
            return this.age.compareTo(o.age);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("str1");
        list2.add("str2");
        list2.add("str3");
        list2.add("str4");
        list2.add("str5");
        list.addAll(list2);
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        list.remove("str1");
        list.remove("str2");
        if (list.equals(list2)) {
            System.out.println("hi");
        }
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("str1");
        list3.add("str2");
        list.retainAll(list3);
        for (String s : list) {
            System.out.println(s);
        }
        List<Integer> ar = new ArrayList<>();
        ar.add(12);
        ar.add(1,17);
        ar.add(127);
        for (Integer i : ar) {
            System.out.println(i);
        }
        ar.add(121);
        ar.add(7);
        List<Integer> ar2 = new ArrayList<>();
        ar2 = ar.subList(1, 4);
        System.out.println(ar2);
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(120);
        set.add(135);
        set.add(12);
        set.add(10);
        for (Integer value : set) {
            System.out.println(value);
        }
        Set<String> ts = new TreeSet<>(new comp().reversed());
        ts.add("A");
        ts.add("C");
        ts.add("Z");
        ts.add("Q");
        ts.add("E");
        for (String str : ts) {
            System.out.println(str);
        }

        Set<user> users = new TreeSet<>();
        //users.addAll(Arrays.asList(new user("suka", 1), new user("loh", 10), new user("valenok", 2)));

        List<user> lt = new ArrayList<>();
        lt.addAll(Arrays.asList(new user("petya", 27), new user("vasya", 41), new user("nadya", 19)));
        for (user us : lt) {
            users.add(us);
        }
        for (user user : users) {
            System.out.println(user.name);
        }
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
