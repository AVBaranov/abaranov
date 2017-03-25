package ru.job4j.array;

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
public class TurnTest {
/**
* Test.
*/
@Test
public void whenfSourceArrayIsEvenThenTurnedArray() {
        Turn obj = new Turn();
	int[] sourcearray = {1, 2, 4, 7, 5, 8, 3, 0, 6, 9};
        int[] standardarray = {9, 6, 0, 3, 8, 5, 7, 4, 2, 1};
	obj.back(sourcearray, 0, sourcearray.length - 1);
        assertThat(sourcearray, is(standardarray));
    }
/**
* Test.
*/
@Test
public void whenfSourceArrayIsOddThenTurnedArray() {
        Turn obj = new Turn();
	int[] sourcearray = {1, 2, 4, 7, 5, 8, 3, 0, 6, 9, 11};
        int[] standardarray = {11, 9, 6, 0, 3, 8, 5, 7, 4, 2, 1};
	obj.back(sourcearray, 0, sourcearray.length - 1);
        assertThat(sourcearray, is(standardarray));
    }
}