package ru.job4j.loop;

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
public class PaintTest {
/**
* Test counts the number of symbols.
*/
@Test
public void whenHeightIsThreeThenNumberOfSymbolsIsNine() {
        Paint obj = new Paint();
	int h = 3;
	int expectation = 9;
	String str = obj.pyramid(h);
	int reality = 0;
	for (char ch : str.toCharArray()) {
	if (ch == '^') {
	reality++;
	}
	}
        assertThat(reality, is(expectation));
    }
/**
* Test compare to the standard string.
*/
@Test
public void whenHeightIsTwoThenReturnsStringEqualsToStandardString() {
        Paint obj = new Paint();
	int h = 2;
	String reality = obj.pyramid(h);
	String expectation = " ^\n^^^\n";
        assertThat(reality, is(expectation));
    }
}