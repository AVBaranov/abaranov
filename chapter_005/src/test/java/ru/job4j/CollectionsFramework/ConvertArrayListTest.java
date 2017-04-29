package ru.job4j.CollectionsFramework;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Andrey Baranov
 * @version $Id$
 * @since 0.1
 */
public class ConvertArrayListTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenArrayHasNineElementsThenCollectionIsTheSame() {
        ConvertArrayList ob = new ConvertArrayList();
        int[][] sourcearray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> reality = new ArrayList<>();
        reality.add(0,1);
        reality.add(1,2);
        reality.add(2,3);
        reality.add(3,4);
        reality.add(4,5);
        reality.add(5,6);
        reality.add(6,7);
        reality.add(7,8);
        reality.add(8,9);
        ArrayList<Integer> expectetion = new ArrayList<>();
        expectetion = (ArrayList<Integer>) ob.toList(sourcearray);
        assertThat(expectetion, is(reality));
    }
    /**
     * Convert collection to array.
     */
    @Test
    public void whenCollectionHasNineElementsThenArrayIsTheSame() {
        ConvertArrayList ob = new ConvertArrayList();
        ArrayList<Integer> sourcecollection = new ArrayList<>();
        sourcecollection.add(0,1);
        sourcecollection.add(1,2);
        sourcecollection.add(2,3);
        sourcecollection.add(3,4);
        sourcecollection.add(4,5);
        sourcecollection.add(5,6);
        sourcecollection.add(6,7);
        //sourcecollection.add(7,8);
        //sourcecollection.add(8,9);
        int[][] expectetion = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] reality;
        reality = ob.toArray(sourcecollection);
        assertThat(expectetion, is(reality));
    }
}
