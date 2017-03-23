package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class CounterTest {
/**
* Test sum.
*/
@Test
public void whenFirstNumberIsOneAndLastNumberIsTenThenSumIsThirty() {
        Counter obj = new Counter();
	int start = 1;
	int finish = 20;
	int expectation = 110;
        int reality = obj.add(start, finish);
        assertThat(reality, is(expectation));
    }

}