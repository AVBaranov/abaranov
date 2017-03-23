package ru.job4j.condition;

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
public class PointTest {
/**
* Test.
*/
@Test
public void whenPointBelongsToFunctionThenReturnTrue() {
        Point obj = new Point(2, 10);
	int a = 4;
	int b = 2;
	boolean expectation = true;
        boolean reality = obj.is(a, b);
        assertThat(reality, is(expectation));
    }

}