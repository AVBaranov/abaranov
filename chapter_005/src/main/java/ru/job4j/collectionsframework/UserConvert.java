package ru.job4j.collectionsframework;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Andrey on 30.04.2017.
 */
public class UserConvert {
    /**
     * method converts List to HashMap.
     * @param list - source List
     * @return List converted to HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hash = new HashMap<>();
        for (User ls : list) {
            hash.put(ls.getId(), ls);
        }
        return hash;
    }
}
