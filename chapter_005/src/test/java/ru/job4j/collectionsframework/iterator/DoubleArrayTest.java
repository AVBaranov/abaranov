package ru.job4j.collectionsframework.iterator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Andrey on 13.05.2017.
 */
public class DoubleArrayTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenThen() {
        DoubleArray ob = new DoubleArray(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        ob.next();
        ob.next();
        ob.next();
        ob.next();
        assertThat(ob.next(), is(5));
        ob.next();
        ob.next();
        ob.next();
        ob.next();
        assertThat(ob.hasNext(), is(false));
    }
}
