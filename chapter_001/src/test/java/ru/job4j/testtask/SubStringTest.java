package ru.job4j.testtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class SubStringTest {
/**
* Test string contains substring.
*/
@Test
public void whenOriginStringContainsSubStringThenReturnTrue() {
        SubString obj = new SubString();
	String str1 = new String("sadfgfsomestringhstsrrsstr");
	String str2 = new String("somestring");
	boolean reality = obj.contains(str1, str2);
	boolean expectation = true;
        assertThat(reality, is(expectation));
    }
}