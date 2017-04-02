package ru.job4j.models;

/**
 * Created by Andrey on 31.03.2017.
 */
public class Item {

    public String name;
    public String description;
    public long create;
    private String id;
    //public Item() {}
    public Item(String name, String description, long create) {
        this.name=name;
        this.description=description;
        this.create=create;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public long getCreate() {
        return this.create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }
    public void setName(String name) {
        this.name=name;
    }



}


