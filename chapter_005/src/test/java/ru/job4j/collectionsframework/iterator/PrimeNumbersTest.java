package ru.job4j.collectionsframework.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Andrey on 13.05.2017.
 */
public class PrimeNumbersTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenThen() {
        PrimeNumbers ob = new PrimeNumbers(new int[] {1,2,3,4,5,6,7,8,9});


        ob.next();
        ob.next();
        ob.next();
        ob.next();
        assertThat(ob.next(), is(7));
        assertThat(ob.hasNext(), is(false));
    }
}
