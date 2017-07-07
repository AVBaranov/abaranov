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
        try (RandomAccessFile rf = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/file.txt", "rw")) {
            int value;
            int i = 0;
            while ((value = rf.read()) != -1) {
                list.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    ll.add(list);
                    list = new ArrayList<>();
                }
                if ((char) value == '\n') {
                    count++;
                }
                if (count >= 5) {
                    count = 0;
                    listchar = new ArrayList<>();
                    List<Object[]> listobj = new ArrayList<>();
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

    }

}
