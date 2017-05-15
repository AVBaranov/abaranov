package ru.job4j.collectionsframework.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 15.05.2017.
 */
public class SimpleArrayTest {

    @Test
    public void whenUseAddThenAppearsNewElement() {
        SimpleArray<String> simple = new SimpleArray<>();
        simple.add("asd");
        assertThat(simple.get(0), is("asd"));
    }

    @Test
    public void whenUseDeleteThenDisappearsChosenElement() {
        SimpleArray<Integer> simple = new SimpleArray<>();
        simple.add(10);
        simple.add(20);
        simple.delete(10);
        assertThat(simple.get(0), is(20));
    }
    @Test
    public void whenUseUpdateThenReplaceChosenElement() {
        SimpleArray<Integer> simple = new SimpleArray<>();
        simple.add(10);
        simple.add(20);
        simple.update(1, 1000);
        assertThat(simple.get(1), is(1000));
    }
    @Test
    public void whenUseGetThenGetElementByIndex() {
        SimpleArray<Integer> simple = new SimpleArray<>();
        simple.add(10);
        simple.add(20);
        simple.add(100);
        assertThat(simple.get(1), is(20));
    }
}