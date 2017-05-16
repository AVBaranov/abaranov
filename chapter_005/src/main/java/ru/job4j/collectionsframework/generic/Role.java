package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 15.05.2017.
 */
public class Role extends Base {
    private String id;

    public Role(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
