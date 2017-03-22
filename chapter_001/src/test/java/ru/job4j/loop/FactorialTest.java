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
public class FactorialTest {
/**
* Test factorial.
*/
@Test
public void whenNumberIsSevenThenFactorialIsFiveThousandAndForty() {
        Factorial obj = new Factorial();
	int n = 7;
	int expectation = 5040;
        int reality = obj.calc(n);
        assertThat(reality, is(expectation));
    }

}