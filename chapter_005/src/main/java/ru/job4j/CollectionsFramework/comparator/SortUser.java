package ru.job4j.CollectionsFramework.comparator;
import java.util.*;
/**
 * Created by Андрей on 02.05.2017.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {

        return new TreeSet<>(list);
    }
}
