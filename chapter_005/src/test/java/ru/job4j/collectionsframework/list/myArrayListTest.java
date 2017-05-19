package ru.job4j.collectionsframework.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 19.05.2017.
 */
public class myArrayListTest {
    @Test
    public void whenAddOneElementthenGetOneElement() {
        myArrayList<String> myar = new myArrayList<>();
        myar.add("str");
        assertThat(myar.get(0), is("str"));
    }

    @Test
    public void whenUseIteratorthenCanFindElementWithIterator() {
        myArrayList<String> myar = new myArrayList<>();
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