package ru.job4j.CollectionsFramework;

/**
 * Created by Andrey on 30.04.2017.
 */
public class User {
    private int id;
    private String name;
    private String city;
    public User(int id, String name, String city) {
        this.city = city;
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return city != null ? city.equals(user.city) : user.city == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
