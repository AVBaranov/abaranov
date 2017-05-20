package ru.job4j.collectionsframework;

import ru.job4j.collectionsframework.generic.*;
import ru.job4j.collectionsframework.generic.User;
import ru.job4j.collectionsframework.testtask.MyComp;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.*;
import ru.job4j.collectionsframework.iterator.*;
import ru.job4j.collectionsframework.list.*;
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

class cl4  {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> iter= it.next();
            while (iter.hasNext()) {
                list.add(iter.next());
            }
        }
        return list.iterator();
    }

}




abstract class abs {
    abstract public String getId();
    abstract public void setId(String id);
}
class uzer extends Base{
    private String id;

    public uzer(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class uzer2 extends Base{
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

interface inter<E extends Base> {

}
class cl1<E extends Base> implements inter {

}
class cl10<E extends Base> implements inter {

}




public class run {
    public static void main(String[] args) {

        Store userstore = new UserStore(new SimpleArray<>());
        Store rolerstore = new RoleStore(new SimpleArray<>());
        User us = new User("asf");
        userstore.add(us);
        System.out.println(userstore.get(0).getId());
        userstore.update(0, new User("sdfsdgsdg"));
        System.out.println(userstore.get(0).getId());
        //System.out.println(userstore.get(1).getId());


        int[] arr = {1};
        EvenNumbers en = new EvenNumbers(arr);
        //System.out.println(en.next());
        System.out.println(en.hasNext());

        ///////////////////////////////////////

        Set<String> set = new TreeSet<>();

        Linkedlist<String> myls = new Linkedlist<>();
        myls.add("str1");
        myls.add("str2");
        myls.add("str3");
        myls.add("str4");
        myls.add("str5");
        myls.add("str6");
        myls.add("str7");
        System.out.println(myls.get(0));
        System.out.println(myls.get(4));
        System.out.println(myls.myiterator(0).next());
        System.out.println(myls.myiterator(1).next());
        //System.out.println(myls.myiterator(7).hasNext());
        LinkedList<String> ls = new LinkedList<>();
        //ListIterator<String> iter = ls.listIterator();
        ls.add("strsdgdfgh1");
        //iter.next();
        System.out.println(ls.iterator().next());
        System.out.println(ls.iterator().hasNext());
        DoubleArray d = new DoubleArray(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(d.next());
        d.next();
        d.next();
        d.next();
        d.next();
        d.next();
        d.next();
        d.next();
        System.out.println(d.hasNext());
        System.out.println(d.next());
        System.out.println(d.hasNext());


















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
