package ru.job4j.CollectionsFramework.comparator;

import ru.job4j.CollectionsFramework.Run;

/**
 * Created by Андрей on 02.05.2017.
 */
public class User implements Comparable<User>{
    private String name;
    private Integer age;
    private Integer nameLength;
    private Integer hashcode;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.nameLength = name.length();
        this.hashcode = hashCode();
    }
    public Integer getHashcode() {
        return hashcode;
    }

    public Integer getNameLength() {
        return nameLength;
    }
    public String getName() {
        return this.name;
    }
    public Integer getAge() {
        return this.age;
    }
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nameLength=" + nameLength +
                ", hashcode=" + hashcode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (nameLength != null ? !nameLength.equals(user.nameLength) : user.nameLength != null) return false;
        return hashcode != null ? hashcode.equals(user.hashcode) : user.hashcode == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (nameLength != null ? nameLength.hashCode() : 0);
        result = 31 * result + (hashcode != null ? hashcode.hashCode() : 0);
        return result;
    }
}