package ru.job4j;

/**
 * Base class.
 */
public class Profession {
    /**
     * human's name.
     */
    private String name;
    /**
     * human's experience.
     */
    private int experience;
    /**
     * human's age.
     */
    private int age;

    /**
     * constructor.
     * @param name set human's name
     * @param age set human's age
     */
    public Profession(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * constructor.
     * @param name set human's name
     */
    public Profession(String name) {
        this.name = name;
    }
    /**
     * method returns human's name.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * method returns human's age.
     * @return age
     */
    public int getAge() {
        return this.age;
    }
}
