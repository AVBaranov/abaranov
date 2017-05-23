package ru.job4j.collectionsframework;

import ru.job4j.collectionsframework.generic.*;
import ru.job4j.collectionsframework.map.User;

import java.util.*;
import ru.job4j.collectionsframework.iterator.*;
import ru.job4j.collectionsframework.list.*;
import ru.job4j.collectionsframework.list.Dequeue;
import ru.job4j.collectionsframework.set.ArraySet;
import ru.job4j.collectionsframework.set.LinkedSet;

/**
 * Created by Andrey on 09.05.2017.
 */
class sorting implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < o1.length(); i++) {
            if(o1.toCharArray()[i] == ' ') {
                count1++;
            }
        }
        for (int i = 0; i < o2.length(); i++) {
            if(o2.toCharArray()[i] == ' ') {
                count2++;
            }
        }
        if (count1 > count2) {
            return 1;
        } else if (count1 < count2) {
            return -1;
        }
        return 0;
    }
}

class megasort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] ar1 = o1.split("/");
        String[] ar2 = o2.split("/");

        for (int i = 0; i < ar1.length && i < ar2.length; i++) {

        }
        boolean b = true;
        for (int i = 0; i < ar1.length && i < ar2.length; i++) {
            if (ar1[i].compareTo(ar2[i]) > 0) {
                b = false;
                return 1;
            } else if (ar1[i].compareTo(ar2[i]) < 0) {
                b = false;
                return -1;
            }
        }
        if (b) {
            if (ar1.length < ar2.length) {
                return -1;
            } else if (ar1.length > ar2.length) {
                return 1;
            }
        }
        return 0;
    }
}

class cl implements Iterator {
    private final int[] values;
    private int index = 0;
    public cl(int[] values) {
        this.values = values;
    }
    int size = 0;
    public Object next() {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }
        size = count;
        int j = 0;
        int[] temp = new int[count];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                temp[j] = values[i];
                j++;
            }
        }
        return temp[index++];
    }

    public boolean hasNext() {
        return size > index;
    }

}

class cl2 implements Iterator {
    private final int[][] values;
    private int index = 0;
    private int index2 = 0;
    int count = 0;
    int template = 0;

    public cl2(int[][] values) {
        this.values = values;
    }

    public Object next() {
        count++;
        if (index2 == values[index].length) {
            index++;
            template += index2;
            index2 = 0;
        }
        return values[index][index2++];
    }

    public boolean hasNext() {
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j= 0; j < values[i].length; j++) {
                temp++;
            }
        }
        return temp > count;
    }
}

class cl3 implements Iterator {
    private final int[] values;
    private int index = 0;
    public cl3(int[] values) {
        this.values = values;
    }
    int size = 0;
    public Object next() {
        int counter = 0;
        for (int i = values.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (values[i] != 1 && values[k] != 1) {
                    if (values[i] % values[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                counter++;
            }
        }
        size = counter;
        int[] temp = new int[counter];
        for (int i = values.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (values[i] != 1 && values[k] != 1) {
                    if (values[i] % values[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                temp[counter - 1] = values[i];
                counter--;
            }
        }
        return temp[index++];
    }

    public boolean hasNext() {
        return size > index;
    }
}




public class run {
    public static void main(String[] args) {




        int[] arr = {1};
        EvenNumbers en = new EvenNumbers(arr);
        System.out.println(en.hasNext());

        ///////////////////////////////////////

        Set<String> set = new TreeSet<>();

        Linkedlist<String> myls = new Linkedlist<>();
        myls.add("str1");
        myls.add("str2");
        myls.add("str3");
        myls.add("str4");
        myls.add("str5");
        myls.add("str1");
        myls.add("str7");
        /*System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().hasNext());
        System.out.println(myls.iterator().next());
        System.out.println(myls.iterator().hasNext());*/
        while (myls.iterator().hasNext()) {
            System.out.println(myls.iterator().next());
        }
        //myls.iterator().next();
        //System.out.println(myls.runhasCycle());


        Dequeue<String> d = new Dequeue<>();
        d.offer("asd");
        d.offer("asdasd");
        d.offer("dasf");

        //System.out.println(d.poll());
        //System.out.println(d.pollLast());
        System.out.println(d.get(0));
        System.out.println(d.iterator().next());
        ArraySet<String> ars = new ArraySet<String>();
        ars.add("asq1");
        ars.add("asq1");
        ars.add("asq3");
        while (ars.hasNext()) {
            System.out.println(ars.next());
        }

        LinkedSet<String> linkset = new LinkedSet<>();
        System.out.println(linkset.add("str"));
        System.out.println(linkset.add("str"));
        System.out.println(linkset.add("str2"));
        while (linkset.hasNext()) {
            System.out.println(linkset.next());
        }

        User user1 = new User("robot", new GregorianCalendar(1002, 1, 1), 2);
        User user2 = new User("robot", new GregorianCalendar(1002, 1, 1), 2);
        Map<User, String> map = new HashMap<>();
        map.put(user1, "biorobot");
        map.put(user2, "robocop");
        System.out.println(map);
        //System.out.println(user1.equals(user2));








    }
    int[] findnaturalnumbers(int[] sourcearray) {

        int counter = 0;
        for (int i = sourcearray.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (sourcearray[i] != 1 && sourcearray[k] != 1) {
                    if (sourcearray[i] % sourcearray[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                counter++;
            }
        }

        int[] template = new int[counter];
        for (int i = sourcearray.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (sourcearray[i] != 1 && sourcearray[k] != 1) {
                    if (sourcearray[i] % sourcearray[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                template[counter - 1] = sourcearray[i];
                counter--;
            }
        }
        return template;
    }

}
