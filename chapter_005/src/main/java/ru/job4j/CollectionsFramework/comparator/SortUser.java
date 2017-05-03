package ru.job4j.CollectionsFramework.comparator;
import java.util.*;
/**
 * Created by Андрей on 02.05.2017.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {

        return new TreeSet<>(list);
    }
    public List<User> sortLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getNameLength().compareTo(o1.getNameLength());
            }
        });
        return users;
    }
    public List<User> sortHash(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getHashcode().compareTo(o1.getHashcode());
            }
        });
        return users;
    }
}
