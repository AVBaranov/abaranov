package ru.job4j.collectionsframework.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 28.05.2017.
 */
public class TreeTest {

    class User implements Comparable<User> {
        private String name;

        public String getName() {
            return name;
        }

        public User(String name) {
            this.name = name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User temp = (User) o;
            return this.name.equals(temp.name);
        }
        @Override
        public int hashCode() {
            return name != null ? name.hashCode() * 31 : 0;
        }
        @Override
        public int compareTo(User o) {
            return  this.name.compareTo(o.name);
        }
    }

    @Test
    public void whenAddThreeTimesTheSameRootthenHaveListOfThreeChilds() {

        Tree<User> tree = new Tree<User>();
        tree.add(new User("White"), new User("Black"));
        tree.add(new User("Black"), new User("Red"));
        tree.add(new User("Red"), new User("Green"));
        tree.iterator().next();
        tree.iterator().next();
        assertThat(tree.iterator().next().getName(), is("Green"));
    }

}