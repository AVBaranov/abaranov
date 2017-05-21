package ru.job4j.collectionsframework.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 20.05.2017.
 */
public class LinkedlistTest {
    @Test
    public void whenAddOneElementthenGetOneElement() {
        Linkedlist<String> myls = new Linkedlist<>();
        myls.add("str");
        assertThat(myls.get(0), is("str"));
    }

    @Test
    public void whenUseIteratorthenCanFindElementWithIterator() {
        Linkedlist<String> myar = new Linkedlist<>();
        myar.add("str1");
        myar.add("str2");
        myar.add("str3");
        myar.add("str4");
        myar.iterator().next();
        assertThat(myar.iterator().next(), is("str2"));
        myar.iterator().next();
        myar.iterator().next();
        assertThat(myar.iterator().hasNext(), is(false));
    }

}