package ru.job4j.collectionsframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Created by Andrey on 09.05.2017.
 */
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

    public cl2(int[][] values) {
        this.values = values;
    }

    public Object next() {
        count++;
        if (index2 == values[index].length) {
            index++;
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

public class run {
    public static void main(String[] args) {
        String[] ar = {"k1/sk1", "k1/", "k1/sk1/ssk1", "k2/", "k1/sk1/ssk2", "k1/sk2"};
        for (String value : ar) {
            System.out.print(value + " ");
        }
        /*for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i].charAt(ar[i].indexOf('/') - 1) > ar[j].charAt(ar[j].indexOf('/') - 1)) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }*/
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i].length() > ar[j].length()) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        /*for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i].charAt(ar[i].indexOf('/') - 1) > ar[j].charAt(ar[j].indexOf('/') - 1)) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }*/

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
               // if (ar[i].charAt(ar[i].indexOf('/') - 1) > ar[j].charAt(ar[j].indexOf('/') - 1)) {
                 //   String temp = ar[i];
                  //  ar[i] = ar[j];
                  //  ar[j] = temp;
                //}
            }
        }

        System.out.println();

        for (String value : ar) {
            System.out.print(value + " ");
        }

        /*for (String s : ar) {
            System.out.println(s.charAt('/'));
        }*/


        System.out.println();

        String str = new String("k1/sk1/ssk1/");
        //System.out.println(str.indexOf('/'));
        //System.out.println(str.charAt(str.indexOf('/') - 1));
        char[] mas = new char[str.length()];
        mas = str.toCharArray();
        /*for (int i = 0; i < mas.length; i++) {
            if (mas[i] == '/') {

            }
        }*/

            for (int i = 0; i < str.length(); i++) {
                if(str.toCharArray()[i] == '/') {
                    System.out.println("kuku");
                }
            }
            //System.out.println(str.charAt('/'));
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


        int[][] arr = new int[10][10];
        arr[1] = new int[] {1,2,3};
        cl2 cl2 = new cl2(new int[][] {{1,2,3,100,200,1000},{4,5,6,123},{7,8,9,10,11}});
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.next());
        System.out.println(cl2.hasNext());

        int[] values = {1,2,3,4,5,6,7,8,9};
        int count = 0;
        System.out.println(count);
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }
        int j = 0;
        int[] temp = new int[count];
        for (int i = 0; i < values.length; i++) {

            if (values[i] % 2 == 0) {
                temp[j] = values[i];
                j++;
            }
        }
        for (int value : temp) {
            System.out.print(value + " ");
        }
        System.out.println();
        cl cl = new cl(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println(cl.next());
        System.out.println(cl.next());
        System.out.println(cl.next());
        System.out.println(cl.next());
        System.out.println(cl.hasNext());


}
}
