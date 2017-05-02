package ru.job4j.CollectionsFramework.comparator;

import ru.job4j.CollectionsFramework.Run;

/**
 * Created by Андрей on 02.05.2017.
 */
public class User implements Comparable<User>{
    private String name;
    private Integer age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public Integer getAge() {
        return this.age;
    }
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
