package ru.job4j.additional_test;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Андрей on 12.10.2017.
 */
public class CheckTest {
    @Test
    public void whenTwoStringEqualsThenReturnTrue() {
        boolean expectation = new Check().contains("string", "gsrtin");
        assertThat(true, is(expectation));
    }
}
