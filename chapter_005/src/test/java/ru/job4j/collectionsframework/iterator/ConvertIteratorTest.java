package ru.job4j.collectionsframework.iterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Andrey Baranov
 * @version $Id$
 * @since 0.1
 */
public class ConvertIteratorTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenArrayHasNineElementsThenCollectionIsTheSame() {
        ConvertIterator ci = new ConvertIterator();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(112);
        list2.add(1);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(4);
        list3.add(14);

        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        Iterator<Integer> it3 = list3.iterator();

        ArrayList<Iterator<Integer>> iterlist = new ArrayList<>();
        iterlist.add(it1);
        iterlist.add(it2);
        iterlist.add(it3);
        myiterofiters<Integer> myitofits = new myiterofiters<Integer>(iterlist);
        Iterator<Integer> expectation = ci.convert(myitofits);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(112);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(14);
        Iterator<Integer> reality = list.iterator();

        expectation.next();
        expectation.next();
        expectation.next();
        expectation.next();
        reality.next();
        reality.next();
        reality.next();
        reality.next();
        assertThat(expectation.next(), is(reality.next()));
    }



}
