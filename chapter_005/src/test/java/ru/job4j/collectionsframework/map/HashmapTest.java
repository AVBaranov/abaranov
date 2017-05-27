package ru.job4j.collectionsframework.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 27.05.2017.
 */
public class HashmapTest {
    @Test
    public void whenInsertElementThenHaveOneAddedElement() {
        Hashmap<String, String> hashmap = new Hashmap<>();
        hashmap.insert("firstkey", "firstvalue");
        assertThat(hashmap.get("firstkey"), is("firstvalue"));
    }
    @Test
    public void whenDeleteOneElementThenHaveMinusOneElement() {
        Hashmap<String, String> hashmap = new Hashmap<>();
        hashmap.insert("firstkey", "firstvalue");
        hashmap.insert("secondtkey", "firstvalue");
        hashmap.delete("firstkey");
        assertThat(hashmap.size(), is(1));
    }

}