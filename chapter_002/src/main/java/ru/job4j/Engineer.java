package ru.job4j;

/**
 * class of engineers.
 */
public class Engineer extends Profession {
    /**
     * constructor.
     * @param name set human's name
     * @param age set human's age
     */
    public Engineer(String name, int age) {
        super(name, age);
    }
    /**
     * position of human at work.
     */
    private String position;

    /**
     * method returns position.
     * @return position
     */
    public String getPosition() {
        return this.position;
    }
}
