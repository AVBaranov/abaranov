package ru.job4j.collectionsframework.map;
import java.util.*;
/**
 * Created by Andrey on 23.05.2017.
 */
public class User {
    private String name;
    private Calendar birthday;
    private int children;

    public User(String name, Calendar birthday, int children) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User temp = (User) o;
        return this.birthday.equals(temp.birthday) && this.name.equals(temp.name) && this.children == temp.children;
    }
    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        result = 31 * result + this.children;
        return result;
    }
}
