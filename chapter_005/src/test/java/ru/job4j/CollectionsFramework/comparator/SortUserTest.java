package ru.job4j.CollectionsFramework.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Андрей on 02.05.2017.
 */
public class SortUserTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenThen() {
        SortUser sortuser = new SortUser();
        Set<User> expectetion = new TreeSet<>();
        expectetion.addAll(Arrays.asList(new User("petya", 27), new User("vasya", 41), new User("nadya", 19)));
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("petya", 27), new User("vasya", 41), new User("nadya", 19)));
        Set<User> reality = sortuser.sort(list);
        assertThat(expectetion, is(reality));
    }
    /**
     * Convert array to collection.
     */
    @Test
    public void whenUseSortLengthThenSortedList() {
        SortUser sortuser = new SortUser();
        List<User> expectetion = new ArrayList<>();
        expectetion.addAll(Arrays.asList(new User("petrushka", 27), new User("nadya", 41), new User("bird", 19)));
        List<User> reality = new ArrayList<>();
        reality.addAll(Arrays.asList(new User("nadya", 41), new User("bird", 19), new User("petrushka", 27)));
        sortuser.sortLength(reality);
        assertThat(expectetion, is(reality));
    }
    /**
     * Convert array to collection.
     */
    @Test
    public void whenUseSortHashThenSortedList() {
        SortUser sortuser = new SortUser();
        List<User> expectetion = new ArrayList<>();
        expectetion.addAll(Arrays.asList(new User("petrushka", 27), new User("nadya", 41), new User("bird", 19)));
        List<User> reality = new ArrayList<>();
        reality.addAll(Arrays.asList(new User("nadya", 41), new User("bird", 19), new User("petrushka", 27)));
        sortuser.sortLength(reality);
        assertThat(expectetion, is(reality));
    }


}