package ru.job4j.collectionsframework;
import java.util.Collection;
/**
 * Created by Andrey on 29.04.2017.
 */
public class EditCollection {
    /**
     * method adds elements collection.
     * @param collection - source collection
     * @param line - line to add
     * @param amount - amount of elements
     * @return time of adding elements to collection
     */
    public long add(Collection<String> collection, String line, int amount) {
        char s = 'a';
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            line = line + s;
            //System.out.println(str);
            collection.add(line);
            s = (char) (s + 1);
        }
        long fn = System.nanoTime();
        return fn - st;
    }
    /**
     * method deletes elements from collection.
     * @param collection - source collection
     * @param amount - amount of elements
     * @return time of deleting elements to collection
     */
    public long delete(Collection<String> collection, int amount) {
        long st = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(0);
        }
        long fn = System.nanoTime();
        return fn - st;
    }
}
