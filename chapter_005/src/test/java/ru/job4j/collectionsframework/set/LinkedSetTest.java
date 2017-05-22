package ru.job4j.collectionsframework.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 22.05.2017.
 */
public class LinkedSetTest {
    @Test
    public void whenAddDuplicateElementThenThatElementWouldNotAppear() {
        LinkedSet<String> arrset = new LinkedSet<>();
        arrset.add("str1");
        arrset.add("str1");
        arrset.add("str2");
        arrset.next();
        assertThat(arrset.next(), is("str2"));
    }
}