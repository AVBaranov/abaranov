package ru.job4j.collectionsframework;

/**
 * Created by Andrey on 30.04.2017.
 */
public class User {
    /**
     * user's id.
     */
    private int id;
    /**
     * user's name.
     */
    private String name;
    /**
     * user's city.
     */
    private String city;
    /**
     * constructor.
     * @param id sets user's id
     * @param name sets user's name
     * @param city sets user's city
     */
    public User(int id, String name, String city) {
        this.city = city;
        this.name = name;
        this.id = id;
    }
    /**
     * method returns user's id.
     * @return user's id
     */
    public int getId() {
        return this.id;
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

        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return city != null ? city.equals(user.city) : user.city == null;
    }
    /**
     * method overrides method hashcode.
     * @return some number
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
