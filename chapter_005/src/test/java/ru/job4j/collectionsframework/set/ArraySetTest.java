package ru.job4j.collectionsframework.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 22.05.2017.
 */
public class ArraySetTest {
    @Test
    public void whenAddDuplicateElementThenThatElementWouldNotAppear() {
        ArraySet<String> arrset = new ArraySet<>();
        arrset.add("str1");
        arrset.add("str1");
        arrset.add("str2");
        arrset.next();
        assertThat(arrset.next(), is("str2"));
    }
}