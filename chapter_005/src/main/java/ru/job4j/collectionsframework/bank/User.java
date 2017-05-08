package ru.job4j.collectionsframework.bank;

/**
 * Created by Андрей on 04.05.2017.
 */
public class User {
    /**
     * user's name.
     */
    private String name;
    /**
     * user's passport.
     */
    private String passport;
    /**
     * constructor.
     * @param name sets user's name
     * @param passport sets user's passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * method returns name.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * method returns passport.
     * @return passport
     */
    public String getPassport() {
        return passport;
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
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }
    /**
     * method overrides method hashcode.
     * @return some number
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
