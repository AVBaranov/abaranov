package ru.job4j.collectionsframework.testtask;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Andrey on 14.05.2017.
 */
public class TestTaskTest {
    /**
     * Test sorts collection.
     */
    @Test
    public void whenCollectionHasNineElementsThenArrayIsTheSame() {
        String[] srcarr = {"k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2", "k2", "k2/sk1", "k2/sk1/ssk1", "k3", "k3/sk1"};
        String[] distarr = {"k1/sk1", "k1/sk2", "k2/sk1/ssk1", "k3", "k1/sk1/ssk2", "k2/sk1", "k3/sk1", "k1", "k2", "k1/sk1/ssk1"};
        Set<String> distset = new TreeSet<>(new MyComp());
        for (String value : distarr) {
            distset.add(value);
        }
        assertThat(distset, is(new TreeSet<>(Arrays.asList(srcarr))));
    }
}
