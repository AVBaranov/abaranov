package ru.job4j;
import ru.job4j.input_output.*;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.util.*;

/**
 * Created by Андрей on 15.06.2017.
 */


 class comparator implements Comparator<List<Character>> {
    @Override
    public int compare(List<Character> o1, List<Character> o2) {
        if (o1.size() >= o2.size()) return 1;
        else if(o1.size() < o2.size()) return -1;
        else return 0;
    }
}


class comp implements Comparator<Character[]> {
    @Override
    public int compare(Character[] o1, Character[] o2) {
        return o1.length >= o2.length ? 1 : -1;
    }
}


public class Run {
    public static void main(String[] args){


        int count = 0;
        List<Character> list = new ArrayList<>();
        List<List<Character>> ll = new ArrayList<>();
        List<Character[]> listchar;
        List<Object[]> listobj = new ArrayList<>();
        List<String> strlist = new ArrayList<>();
        String str = new String("");
        try (RandomAccessFile rf = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/file.txt", "rw")) {
            int value;
            int i = 0;
            while ((value = rf.read()) != -1) {
                str += (char) value;
                list.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    ll.add(list);
                    list = new ArrayList<>();
                    strlist.add(str);
                    str = "";
                }
                if ((char) value == '\n') {
                    count++;
                }
                if (count >= 5) {
                    count = 0;
                    listchar = new ArrayList<>();
                    listobj = new ArrayList<>();
                    for (int j = 0; j < ll.size(); j++) {
                        listobj.add(ll.get(j).toArray());
                    }
                    for (int x = 0; x < listobj.size(); x++) {
                        Character[] temp = new Character[listobj.get(x).length];
                        for (int y = 0; y < listobj.get(x).length; y++) {
                            temp[y] = (Character) listobj.get(x)[y];
                        }
                        listchar.add(temp);
                    }
                    listchar.sort(new comp());

                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (i + 1) + ".txt", "rw");

                    for (int j = 0; j < listchar.size(); j++) {
                        byte[] ar = new byte[listchar.get(j).length];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) (char) listchar.get(j)[k];
                        }
                        r.write(ar);

                    }
                    ll.clear();
                    i++;
                }
            }

        }
        catch (IOException e) {
            e.getMessage();
        }


//        String[] ar1 = {"asd", "asdaa", "dsfsdfgsd", "asfsdfsfsf", "sdfsdfsdfsfsfs"};
//        String[] ar2 = {"a", "sdsdf", "sdfsdfdsf", "sdfsdfsdfdsfs", "dqdsfggqerfefghfghfgh"};
//        String[] sumar = (mergesort(ar1, ar2));
//        for (String value : sumar) {
//            System.out.println(value);
//        }
        String[] strar = new String[strlist.size()];
        for (int i = 0; i < strar.length; i++) {
            strar[i] = (String) strlist.toArray()[i];
        }
        /*for (String value : strar) {
            System.out.print(value);
        }*/

        List<String> endlist1 = new ArrayList<>();
        String endstr1 = new String("");
        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part1.txt", "rw")) {
            int value;
            while ((value = ra.read()) != -1) {
                endstr1 += (char) value;
                if (((Character) (char) value).equals('\n')) {
                    endlist1.add(endstr1);
                    endstr1 = "";
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        List<String> endlist2 = new ArrayList<>();
        String endstr2 = new String("");
        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part2.txt", "rw")) {
            int value;
            while ((value = ra.read()) != -1) {
                endstr2 += (char) value;
                if (((Character) (char) value).equals('\n')) {
                    endlist2.add(endstr2);
                    endstr2 = "";
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        /*for(String value : endlist1) {
            System.out.print(value);
        }

        for(String value : endlist2) {
            System.out.print(value);
        }*/

        String[] finalar1 = new String[endlist1.size()];
        String[] finalar2 = new String[endlist2.size()];
        for (int i = 0; i < finalar1.length; i++) {
            finalar1[i] = (String) endlist1.toArray()[i];
        }
        for (int i = 0; i < finalar2.length; i++) {
            finalar2[i] = (String) endlist2.toArray()[i];
        }
        String[] finalarray = mergesort(finalar1, finalar2);
        for (String value : finalarray) {
            System.out.print(value);
        }


    }

    public static String[] mergesort(String[] array1, String[] array2) {
        String[] array = new String[array1.length + array2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i == array1.length) {
                array[k] = array2[j];
                j++;
                continue;
            }
            if (j == array2.length) {
                array[k] = array1[i];
                i++;
                continue;
            }
            if (array1[i].length() <= array2[j].length()) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
        }
        return array;
    }

}
