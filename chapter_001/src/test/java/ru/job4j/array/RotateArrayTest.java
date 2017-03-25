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
public class RotateArrayTest {
/**
* Test.
*/
@Test
public void whenFirstElementOfSourceArrayIsOneThenThirdElementOfRotateArrayIsOne() {
        RotateArray obj = new RotateArray();
	int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] turnedarray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
	obj.rotate(array);
        assertThat(array, is(turnedarray));
    }
/**
* Test.
*/
@Test
public void whenFirstElementOfSourceArrayIsOneThenSecondElementOfRotateArrayIsOne() {
        RotateArray obj = new RotateArray();
	int[][] array = {{1, 2}, {3, 4}};
        int[][] turnedarray = {{3, 1}, {4, 2}};
	obj.rotate(array);
        assertThat(array, is(turnedarray));
    }
}