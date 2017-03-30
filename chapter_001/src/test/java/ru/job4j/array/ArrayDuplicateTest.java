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
public class ArrayDuplicateTest {
/**
* Test.
*/
@Test
public void whenRemoveDuplicatesThenArrayWithoutDuplicates() {
        ArrayDuplicate obj = new ArrayDuplicate();
	String[] sourcearray = {"Hello", "Super", "Hello", "World", "World", "World", "Hello", "World", "Super"};
        String[] cutarray = {"Hello", "Super", "World"};
        assertThat(obj.remove(sourcearray), is(cutarray));
    }
}