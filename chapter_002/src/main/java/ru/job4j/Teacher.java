package ru.job4j;

/**
 * class of teachers.
 */
public class Teacher extends Profession {
    /**
     * constructor.
     * @param name set human's name
     * @param age set human's age
     */
    public Teacher(String name, int age) {
        super(name, age);
    }
    /**
     * subject neme.
     */
    private String subject;

    /**
     * method set subject's name.
     * @param subject discribes subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * method returns subject's name.
     * @return name
     */
    public String getSubject() {
        return this.subject;
    }
}
