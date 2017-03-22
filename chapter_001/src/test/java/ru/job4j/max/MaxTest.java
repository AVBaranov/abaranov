package ru.job4j.max;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class MaxTest {
/**
* Test max first parameter.
*/
@Test
public void whenFirstMaxThenReturnFirst() {
        Max obj = new Max();
	int first = 100;
	int second = 20;
	int expectation = 100;
        int reality = obj.max(first, second);
        assertThat(reality, is(expectation));
    }
/**
* Test max second parameter.
*/
@Test
public void whenSecondMaxThenReturnSecond() {
        Max obj = new Max();
	int first = 100;
	int second = 2000;
	int expectation = 2000;
        int reality = obj.max(first, second);
        assertThat(reality, is(expectation));
    }

}