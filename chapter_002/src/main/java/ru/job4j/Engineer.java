package ru.job4j;

/**
 * class of engineers.
 */
public class Engineer extends Profession {
    /**
     * human's name.
     */
    private String name;
    /**
     * constructor.
     * @param name set human's name
     * @param age set human's age
     */
    public Engineer(String name, int age) {
        super(name, age);
        this.name = name;
    }
    /**
     * constructor.
     * @param name set human's name
     */
    public Engineer(String name) {
        super(name);
        this.name = name;
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
    /**
     * method returns position.
     * @param build - name of building
     * @return position
     */
    public String build(Building build) {
        return String.format("%s %s %s %s", "инженер", getName(), "строит здание ", build.getName());
    }
}
