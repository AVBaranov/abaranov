package ru.job4j.CollectionsFramework.comparator;
import java.util.*;
/**
 * Created by Андрей on 02.05.2017.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> setuser = new TreeSet<>();
        for (User user : list) {
            setuser.add(user);
        }
        return setuser;
    }
}
