package ru.job4j.collectionsframework.comparator;

/**
 * Created by Андрей on 02.05.2017.
 */
public class User implements Comparable<User> {
    /**
     * user's name.
     */
    private String name;
    /**
     * user's age.
     */
    private Integer age;
    /**
     * user's name's length.
     */
    private Integer nameLength;
    /**
     * user's hashcode.
     */
    private Integer hashcode;
    /**
     * constructor.
     * @param name sets user's name
     * @param age sets user's age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.nameLength = name.length();
        this.hashcode = hashCode();
    }
    /**
     * method returns hashcode.
     * @return hashcode
     */
    public Integer getHashcode() {
        return hashcode;
    }
    /**
     * method returns name's length.
     * @return name's length
     */
    public Integer getNameLength() {
        return nameLength;
    }
    /**
     * method returns user's name.
     * @return user's name
     */
    public String getName() {
        return this.name;
    }
    /**
     * method returns user's age.
     * @return user's age
     */
    public Integer getAge() {
        return this.age;
    }
    /**
     * method overrides method compareTo.
     * @param o - variable to compare
     * @return 1 or 0 or -1
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
    /**
     * method overrides method toString.
     * @return new String
     */
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", nameLength=" + nameLength + ", hashcode=" + hashcode + '}';
    }
    /**
     * method overrides method equals.
     * @param o - variable to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (age != null ? !age.equals(user.age) : user.age != null) {
            return false;
        }
        if (nameLength != null ? !nameLength.equals(user.nameLength) : user.nameLength != null) {
            return false;
        }
        return hashcode != null ? hashcode.equals(user.hashcode) : user.hashcode == null;
    }
    /**
     * method overrides method hashcode.
     * @return some number
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (nameLength != null ? nameLength.hashCode() : 0);
        result = 31 * result + (hashcode != null ? hashcode.hashCode() : 0);
        return result;
    }
}