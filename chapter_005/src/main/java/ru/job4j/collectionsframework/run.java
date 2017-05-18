package ru.job4j.collectionsframework;

import ru.job4j.collectionsframework.generic.*;
import ru.job4j.collectionsframework.generic.User;
import ru.job4j.collectionsframework.testtask.MyComp;
import java.util.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import ru.job4j.collectionsframework.iterator.*;
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
        String[] ar = {"k1/sk1", "k1/", "k1/sk1/ssk1", "k2/", "k1/sk1/ssk2", "k1/sk2"};
        for (String value : ar) {
            System.out.print(value + " ");
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i].length() > ar[j].length()) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                for (int k = 0; k < ar[i].length(); k++) {
                    if (ar[i].toCharArray()[k] == '/' && ar[j].toCharArray()[k] == '/') {
                       // ar[i].charAt(ar[i].toCharArray()[k]);
                        /*if (k >= ar[i].length() || k >= ar[j].length()) {
                            break;
                        }*/
                        if (ar[i].charAt(ar[i].indexOf('/') - 1) > ar[j].charAt(ar[j].indexOf('/') - 1)) {
                            String temp = ar[i];
                            ar[i] = ar[j];
                            ar[j] = temp;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println();

        for (String value : ar) {
            System.out.print(value + " ");
        }



        System.out.println();

        String str = new String("k1/sk1/ssk1/");
        char[] mas = new char[str.length()];
        mas = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if(str.toCharArray()[i] == '/') {
                    System.out.println("kuku");
                }
            }
        System.out.println(str.indexOf('/'));
            System.out.println(str.charAt(str.indexOf('/') - 1));
        String[] ar2 = {"k1/sk1", "k1", "k1/sk1/ssk1", "k2", "k1/sk1/ssk2", "k1/sk2", "k1/sk1/ssk3"};
        String s = new String("sdfsd");
        char[] mass = new char[ar[0].length()];
        mass = ar[0].toCharArray();
        List<String> list = Arrays.asList(ar2[0].split("/"));
        ar2[0].split("/");
        for (String value : ar2) {
            System.out.println(value);
        }
        System.out.println();
        for (int i = 0; i < ar2.length; i++) {
            for (int j = i + 1; j < ar2.length; j++) {
                if (ar2[i].length() > ar2[j].length()) {
                    String temp = ar2[i];
                    ar2[i] = ar2[j];
                    ar2[j] = temp;
                }
            }
        }
        for (String value : ar2) {
            System.out.println(value);
        }
        for (int i = 0; i < ar2.length; i++) {
            for (int j = i + 1; j < ar2.length; j++) {
                for (int k = 0; k < ar[i].length(); k++) {

                    if (ar2[i].charAt(ar2[i].length() - 1) > ar2[j].charAt(ar2[j].length() - 1)) {
                        String temp = ar2[i];
                        ar2[i] = ar2[j];
                        ar2[j] = temp;
                    }
                    if (ar2[i].length() < ar2[j].length() && ar2[i].charAt(ar2[i].length() - 1) > ar2[j].charAt(ar2[j].length() - 1)) {
                        break;
                    }
                }
            }
        }
        System.out.println();
        for (String value : ar2) {
            System.out.println(value);
        }
        String[] s1 = {"s1", "sk1", "ssk2"};
        String[] s2 = {"s1", "s2", "sk1", "ssk1"};
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[i].length(); j++) {
                if (s1[i].charAt(s1[i].length() - 1) > s2[i].charAt(s2[i].length() - 1)) {
                    String temp = s1[i];
                    s1[i] = s2[i];
                    s2[i] = temp;
                }
            }
        }
        String z1 = ("asd");
        System.out.println(z1.compareTo(new String("asd2")));
        System.out.println();
        String[] strarr = {"k1/sk1", "k1/sk2", "k2/sk1/ssk1", "k3", "k1/sk1/ssk2", "k2/sk1", "k3/sk1", "k1", "k2", "k1/sk1/ssk1"};
        int a = strarr[0].split("/").length;
        System.out.println(a);
        String[][] distarr = new String[strarr.length][];
        for (int i = 0; i < strarr.length; i++) {
            distarr[i] = strarr[i].split("/");
        }

        for (int i = 0; i < distarr.length; i++) {
            for (int j = 0; j < distarr[i].length; j++) {
                System.out.print(distarr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < distarr.length; i++) {
            for (int j = 0; j < distarr[i].length; j++) {
                for (int k = j + 1; k < distarr[i][j].length() - 1; k++) {
                    //if (!(distarr[i][j].length() > k) || )
                    if (distarr[i][k].compareTo(distarr[i][k + 1]) < 0) {
                        String temp = distarr[i][k];
                        distarr[i][k] = distarr[i][k + 1];
                        distarr[i][k + 1] = temp;
                    }
                }
            }
        }
        String st1 = new String("ssk1");
        System.out.println(st1.compareTo(new String("sk2")));
        for (int i = 0; i < distarr.length; i++) {
            for (int j = 0; j < distarr[i].length; j++) {
                System.out.print(distarr[i][j] + " ");
            }
            System.out.println();
        }





        List<String> lz = Arrays.asList(strarr);
        Set<String> st = new TreeSet<>(new MyComp());
        for (String value : lz) {
            st.add(value);
        }
        System.out.println(st);

        /*String[] ar1 = new String("str").split("/");
        for (String value : ar1) {
            System.out.print(value + " ");
        }
        System.out.println();
        String[] ar3 = new String("str/asq/xcv").split("/");
        for (String value : ar3) {
            System.out.println(value + " ");
        }*/
        DoubleArray ob = new DoubleArray(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        while (ob.hasNext()) {
            System.out.println(ob.next());
        }


        SimpleArray<Integer> obs = new SimpleArray<>();
        obs.add(1);
        obs.add(2);
        obs.add(3);
        obs.add(4);
        obs.add(5);
        obs.add(6);
        obs.add(7);
        obs.add(8);
        System.out.println(obs.get(0));
        obs.delete(1);
        System.out.println(obs.get(0));
        System.out.println(obs.get(4));
        obs.update(4,100);
        System.out.println(obs.get(4));

        //inter<Base> cl1 = new cl1<uzer>();
        //inter<Base> cl10 = new cl10<uzer2>();
        //SimpleArray<User> simplearr = new SimpleArray<>();
        Store<User> userstore = new UserStore(new SimpleArray<>());
        Store<Role> rolerstore = new RoleStore(new SimpleArray<>());
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

        List<String> ls = new ArrayList<>();
        ls.add("str1");
        ls.add("str1");
        myiter<String> myiter = new myiter<>(ls);
        System.out.println(myiter.next());
        System.out.println(myiter.hasNext());

        ArrayList<Iterator<Integer>> ls2 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(1000);
        Iterator<Integer> it = list1.iterator();
        Iterator<Integer> it2 = new ArrayList<Integer>().iterator();
        ls2.add(it);
        ls2.add(it2);

        myiterofiters<Integer> myitofits = new myiterofiters<Integer>(ls2);
        System.out.println(myitofits.next().next());
        System.out.println(myitofits.hasNext());


        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(50);
        List<Integer> l2 = new ArrayList<>();
        l1.add(100);
        l1.add(200);
        l1.add(500);
        List<Integer> l3 = new ArrayList<>();
        l1.add(1000);
        l1.add(2000);
        l1.add(5000);
        Iterator<Integer> i1 = l1.iterator();
        Iterator<Integer> i2 = l2.iterator();
        Iterator<Integer> i3 = l3.iterator();
        ArrayList<Iterator<Integer>> itlist = new ArrayList<>();
        itlist.add(i1);
        itlist.add(i2);
        itlist.add(i3);
        Iterator<Iterator<Integer>> megaiter = itlist.iterator();
        myiterofiters<Integer> myitofits2 = new myiterofiters<Integer>(itlist);
        ConvertIterator conv = new ConvertIterator();
        Iterator<Integer> result = conv.convert(myitofits2);
        while (result.hasNext()) {
            System.out.println(result.next());
        }

        int[] ar1 = {1,2,3,4,5,6,7,8,9};
        int temp = ar1.length + (ar1.length >> 1);
        System.out.println(temp);
        ar1 = Arrays.copyOf(ar1, ar1.length + (ar1.length >> 1));

        for (int value : ar1) {
            System.out.print(value + " ");
        }
        System.out.println("\n" + Object[].class);

        PrimeNumbers pn = new PrimeNumbers(new int[] {1,2,3,4,5,6,7,8,9});
        while (pn.hasNext()) {
            System.out.println(pn.next());
        }













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
