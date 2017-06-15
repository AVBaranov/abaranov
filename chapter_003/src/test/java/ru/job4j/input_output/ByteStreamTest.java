package ru.job4j.input_output;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 15.06.2017.
 */
public class ByteStreamTest {
    @Test
    public void whenInputEvenNumberThenGetTrue() {
        ByteStream bs = new ByteStream();
        assertThat(bs.isNumber(System.in), is(true));
    }

}