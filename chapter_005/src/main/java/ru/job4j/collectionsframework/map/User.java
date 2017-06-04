package ru.job4j.collectionsframework.map;
import java.util.*;
/**
 * Created by Andrey on 23.05.2017.
 */
public class User {
    private String name;
    private Calendar birthday;
    private int children;
    boolean b;
    double d;
    double dd;
    float f;
    char ch;

    public User(String name, Calendar birthday, int children) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User Temp = (User) o;
        return this.birthday.equals(Temp.birthday) && this.name.equals(Temp.name) && this.children == Temp.children;
    }
    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + (this.birthday != null ? this.birthday.hashCode() : 0);
        result = 31 * result + this.children;
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (b != user.b) return false;
        if (Double.compare(user.d, d) != 0) return false;
        if (Double.compare(user.dd, dd) != 0) return false;
        if (Float.compare(user.f, f) != 0) return false;
        if (ch != user.ch) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + children;
        result = 31 * result + (b ? 1 : 0);
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (f != +0.0f ? Float.floatToIntBits(f) : 0);
        result = 31 * result + (int) ch;
        return result;
    }
}
