package ru.job4j.input_output;

import java.io.*;
import java.util.*;

/**
 * Created by Andrey on 18.06.2017.
 */
class comparator implements Comparator<List<Character>> {
    @Override
    public int compare(List<Character> o1, List<Character> o2) {
        if (o1.size() >= o2.size()) return 1;
        else if(o1.size() < o2.size()) return -1;
        else return 0;
    }
}
public class SortFile {

    public void sort(File srcfile, File destfile) {
        Set<List<Character>> set = new TreeSet<>(new comparator());

        List<Character> buffer = new ArrayList<>();

        try (RandomAccessFile ra = new RandomAccessFile(srcfile, "r");) {

            int value;
            while ((value = ra.read()) != -1) {
                buffer.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    set.add(buffer);
                    buffer = new ArrayList<>();
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        try (RandomAccessFile ra = new RandomAccessFile(destfile, "rw");) {
            for (List<Character> value : set) {
                for (Character value2 : value) {
                    ra.write(value2);
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
    }


}
