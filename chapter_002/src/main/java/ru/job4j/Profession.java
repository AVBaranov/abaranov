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
    /**
     * method sets human's name.
     * @param name discribes name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * method sets human's age.
     * @param age discribes age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
