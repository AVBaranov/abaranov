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
}
