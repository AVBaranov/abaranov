package ru.job4j.collectionsframework;

/**
 * Created by Andrey on 09.05.2017.
 */
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
                for (int k = 0; k < ar.length; k++) {
                    if (ar[i].toCharArray()[k] == '/' && ar[j].toCharArray()[k] == '/') {
                        ar[i].charAt(ar[i].toCharArray()[k]);
                    }
                }
               /* if (ar[i].charAt(ar[i].indexOf('/') - 1) > ar[j].charAt(ar[j].indexOf('/') - 1)) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }*/
            }
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


    }
}
