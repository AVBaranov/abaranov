package ru.job4j.CollectionsFramework;
import java.util.*;
/**
 * Created by Andrey on 29.04.2017.
 */
public class EditCollection {
    public long add(Collection<String> collection, String line, int amount) {
        char s = 'a';
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            line = line +s;
            //System.out.println(str);
            collection.add(line);
            s = (char)(s + 1);
        }
        long fn = System.nanoTime();
        return fn - st;
    }
    public long delete(Collection<String> collection, int amount) {
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(0);
        }
        long fn = System.nanoTime();
        return fn - st;
    }

}
