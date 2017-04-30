package ru.job4j.CollectionsFramework;

/**
 * Created by Andrey on 30.04.2017.
 */
public class User {
    private int id;
    private String name;
    private String city;
    public User(int id, String name, String city) {
        this.city = city;
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
}
