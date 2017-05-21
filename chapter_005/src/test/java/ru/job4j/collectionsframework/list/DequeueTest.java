package ru.job4j.collectionsframework.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 22.05.2017.
 */
public class DequeueTest {
    @Test
    public void whenUsePushthenAddOneElementToHead() {
        Dequeue<String> myls = new Dequeue<>();
        myls.push("str1");
        myls.push("str2");
        myls.push("str3");
        myls.push("str4");
        assertThat(myls.get(0), is("str4"));
    }

    @Test
    public void whenUseOfferthenAddOneElementToTail() {
        Dequeue<String> myls = new Dequeue<>();
        myls.offer("str1");
        myls.offer("str2");
        myls.offer("str3");
        myls.offer("str4");
        assertThat(myls.get(0), is("str1"));
    }

    @Test
    public void whenUsePollthenGetElementFromHead() {
        Dequeue<String> myls = new Dequeue<>();
        myls.offer("str1");
        myls.offer("str2");
        assertThat(myls.poll(), is("str1"));
    }

    @Test
    public void whenUsePollLastthenGetElementFromTail() {
        Dequeue<String> myls = new Dequeue<>();
        myls.offer("str1");
        myls.offer("str2");
        assertThat(myls.pollLast(), is("str2"));
    }
}