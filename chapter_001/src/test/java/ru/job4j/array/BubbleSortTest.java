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
public class BubbleSortTest {
/**
* Test.
*/
@Test
public void whenfSourceArrayIsUnsortedThenSortedArray() {
        BubbleSort obj = new BubbleSort();
	int[] sourcearray = {1, 2, 4, 7, 5, 8, 3, 0, 6, 9};
        int[] sortedarray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	obj.sort(sourcearray);
        assertThat(sourcearray, is(sortedarray));
    }
}