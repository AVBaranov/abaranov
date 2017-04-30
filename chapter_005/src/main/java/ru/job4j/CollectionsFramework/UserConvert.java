package ru.job4j.CollectionsFramework;
import java.util.*;
/**
 * Created by Andrey on 30.04.2017.
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hash = new HashMap<>();
        for (User ls : list) {
            hash.put(ls.getId(), ls);
        }
        return hash;
    }
}
