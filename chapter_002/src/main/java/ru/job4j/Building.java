package ru.job4j;

/**
 * Created by Andrey on 11.04.2017.
 */
public class Building {
    /**
     * human's name.
     */
    private String name;
    /**
     * constructor.
     * @param name set human's name
     */
    public Building(String name) {
        this.name = name;
    }
    /**
     * method returns name of building.
     * @return name of building
     */
    public String getName() {
        return this.name;
    }
}
