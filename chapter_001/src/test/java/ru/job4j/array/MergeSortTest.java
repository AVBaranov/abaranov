package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class MergeSortTest {
/**
* Test.
*/
@Test
public void whenSortedArraysAreFirstArrayAndSecondArrayThenMergeArray() {
        MergeSort obj = new MergeSort();
	int[] firstarray = {1, 2, 5};
        int[] secondarray = {1, 4, 7, 9};
	int[] mergearray = obj.mergesort(firstarray, secondarray);
	int[] expectedarray = {1, 1, 2, 4, 5, 7, 9};
        assertThat(mergearray, is(expectedarray));
    }
}